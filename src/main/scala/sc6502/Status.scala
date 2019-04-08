package sc6502

class Status(val value: Int = 0) {
  var Negative, Overflow, Break, Decimal, Interrupt, Zero, Carry = false
  private var undocumented = false

  fromInt(value)

  def asInt() : Int = {
    var res: Int = 0

    res += (if (Negative) 0x80 else 0)
    res += (if (Overflow) 0x40 else 0)

    res += (if (undocumented) 0x20 else 0)

    res += (if (Break) 0x10 else 0)
    res += (if (Decimal) 0x08 else 0)

    res += (if (Interrupt) 0x04 else 0)
    res += (if (Zero) 0x02 else 0)
    res += (if (Carry) 0x01 else 0)
    res
  }

  def fromInt(value: Int)= {
    Negative = (value & 0x80) != 0
    Overflow = (value & 0x40) != 0
    undocumented = (value & 0x20) != 0
    Break = (value & 0x10) != 0
    Decimal = (value & 0x08) != 0
    Interrupt = (value & 0x04) != 0
    Zero = (value & 0x02) != 0
    Carry = (value & 0x01) != 0

  }
}
