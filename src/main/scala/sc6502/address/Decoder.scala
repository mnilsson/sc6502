package sc6502.address
import sc6502.Cpu
import sc6502.memory.MappedMemory

object Decoder {

  def getAddress(cpu: Cpu, bus: MappedMemory, addressingMode: AddressingMode) : DecodedAddress = {
    addressingMode match {
      case Absolute() => new DecodedAddress(addressingMode, bus.readWord(cpu.pc), 2)
      case AbsoluteIndirect() => new DecodedAddress(addressingMode, bus.readWord(bus.readWord(cpu.pc)), 2)
      case AbsoluteX() => new DecodedAddress(addressingMode, (bus.readWord(cpu.pc) + cpu.x) & 0xffff, 2)
      case AbsoluteY() => new DecodedAddress(addressingMode, (bus.readWord(cpu.pc) + cpu.y) & 0xffff, 2)
      case ZeroPage() => new DecodedAddress(addressingMode, bus.read(cpu.pc), 1)
      case ZeroPageX() => new DecodedAddress(addressingMode, (bus.read(cpu.pc) + cpu.x) & 0xff, 1)
      case ZeroPageY() => new DecodedAddress(addressingMode, (bus.read(cpu.pc) + cpu.y) & 0xff, 1)
      case IndexedIndirectX() => {
        val byte = bus.read(cpu.pc)
        val naddr = (byte + cpu.x) & 0xff
        val lo = bus.read(naddr)
        val hi = bus.read((naddr +1) & 0xff)
        val raddr = (hi << 8) | lo

        bus.read(naddr) // dummy read

        new DecodedAddress(addressingMode, raddr, 1)
      }
      case IndirectIndexedY() => {
        val addr = bus.read(cpu.pc)
        val lo = bus.read(addr)
        val hi = bus.read((addr & 0xff00) | ((addr +1) & 0xff))
        val naddr = ((hi << 8) | lo) + cpu.y

        new DecodedAddress(addressingMode, naddr & 0xffff, 1)
      }
      case Immediate() => new DecodedAddress(addressingMode, cpu.pc, 1)
      case Accumulator() => new DecodedAddress(addressingMode, 0, 1)
    }
  }

}
