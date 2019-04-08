package sc6502.memory

trait MappedMemory {
  def read(address: Int) : Int
  def write(address: Int, value: Int)
  def readWord(address: Int) : Int = {
    val high = read(address + 1) << 8
    val low = read(address)
    high | low
  }

  def writeWord(address: Int, value: Int): Unit = {
    val high = (value >> 8) & 0xff
    val low = value & 0xff

    write(address, low)
    write(address + 1, high)
  }

  def tick()
}
