import sc6502.memory.Memory

class MemoryTest extends org.scalatest.FunSuite {

  test("cpu.memory.Memory size is correct") {
    val memory = new Memory
    assert(memory.memory.length === 0x10000)
  }

  test("cpu.memory.Memory.read") {
    val memory = new Memory

    memory.write(0x100, 0x10)
    val result = memory.read(0x100)
    assert(result === 0x10)
  }

}
