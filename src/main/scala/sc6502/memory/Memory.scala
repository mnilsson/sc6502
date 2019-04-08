package sc6502.memory

class Memory {
  var memory = Array.fill[Int](0x10000)(0)

  def read(address: Int) : Int = {
    val res = memory(address)
    res
  }

  def write(address: Int, value: Int) : Unit = {
    memory(address) = value
  }



}
