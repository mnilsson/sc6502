package sc6502

import org.scalatest.FunSuite
import sc6502.memory.{Memory, MappedMemory}

class CpuTest extends FunSuite {

  class Bus extends MappedMemory {
    var ticks = 0
    var memory = new Memory()
    memory.write(0x100, 0x69) // Adc #oper
    memory.write(0x200, 0xa1) // lda (3e,x)
    memory.write(0x201, 0x3e) // lda (3e,x)
    memory.write(0x43, 0x15)
    memory.write(0x44, 0x24)
    memory.write(0x2415, 0x6e)

    memory.write(0x300, 0xa9) // lda $20
    memory.write(0x301, 0x20) // lda $20

    memory.write(0x400, 0xb1) // lda (3e,x)
    memory.write(0x401, 0x4c) // lda (3e,x)
    memory.write(0x4c, 0x00)
    memory.write(0x4d, 0x21)
    memory.write(0x2105, 0x6d)

    def read(address: Int): Int = {
      val value = memory.read(address)
      tick()
      value
    }

    def write(address: Int, value: Int): Unit = {
      memory.write(address, value)
      tick()
    }

    override def tick(): Unit = {
      ticks+=1
    }
  }

  test("testStep cycles Adc #00") {
    val bus = new Bus
    val cpu = new Cpu
    cpu.pc = 0x100
    cpu.step(bus)
    assert(bus.ticks === 2)
  }

  test("testStep cycles Lda $20") {
    val bus = new Bus
    bus.ticks = 0
    val cpu = new Cpu
    cpu.pc = 0x300

    cpu.step(bus)
    assert(cpu.a === 0x20)
    assert(bus.ticks === 2)
  }

  test("testStep cycles Lda ($3e,x)") {
    val bus = new Bus
    bus.ticks = 0
    val cpu = new Cpu
    cpu.pc = 0x200
    cpu.x = 0x05
    cpu.step(bus)
    assert(cpu.a === 0x6e)
    assert(bus.ticks === 6)
  }

  test("testStep cycles Lda ($3e),y") {
    val bus = new Bus
    bus.ticks = 0
    val cpu = new Cpu
    cpu.pc = 0x400
    cpu.y = 0x05
    cpu.step(bus)
    assert(cpu.a === 0x6d)
    assert(bus.ticks === 5)
  }
}
