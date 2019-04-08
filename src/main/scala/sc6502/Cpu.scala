package sc6502

import sc6502.address.AddressingMode
import sc6502.memory.MappedMemory
import sc6502.address.{Decoder => AddressDecoder}

class Cpu {
  var a= 0
  var x= 0
  var y= 0
  var p = new Status(0x32)
  var sp = 0xfd
  var pc = 0
  var h = 0

  def step(bus: MappedMemory): Unit = {
    val instruction = Decoder.decode(readImmediate(bus))
    executeInstruction(instruction, bus)

  }

  def executeInstruction(instruction: Instruction, bus: MappedMemory): Unit = {
    instruction match {
      case Adc(addressingMode) => adc(bus, addressingMode)
      case Lda(addressingMode) => lda(bus, addressingMode)
      case _ => 1
    }
  }

  def readImmediate(bus: MappedMemory): Int = {
    val result = bus.read(pc)
    pc += 1
    result
  }

  private def adc(bus: MappedMemory, addressingMode: AddressingMode): Unit = {
    val decodedAddress = AddressDecoder.getAddress(this, bus, addressingMode)
    val value = bus.read(decodedAddress.address)
    val result = value + a + (if (p.Carry) 1 else 0)

    p.Carry = (result & 0x100) != 0
    p.Overflow = ((a ^ value) & 0x80) == 0 && ((a ^ result) & 0x80) == 0x80
    p.Negative = (result & 0x80) == 0x80
    p.Zero = result == 0

    a = result
    pc = pc + decodedAddress.pcInc
  }

  private def lda(bus: MappedMemory, addressingMode: AddressingMode): Unit = {
    val decodedAddress = AddressDecoder.getAddress(this, bus, addressingMode)
    val value = bus.read(decodedAddress.address)
    a = value

    p.Negative = (value & 0x80) == 0x80
    p.Zero = value == 0
    pc += decodedAddress.pcInc
  }
}
