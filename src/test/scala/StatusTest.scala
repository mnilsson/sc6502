import sc6502.Status
import org.scalatest.FunSuite

class StatusTest extends FunSuite {

  test("initial values") {
    val status = new Status(0xde)
    assert(status.asInt() === 0xde)
  }

  test("testAsInt") {
    val status = new Status
    assert(status.asInt() === 0)

    status.Negative = true
    assert(status.asInt() === 0x80)
  }

  test("testFromInt") {
    val status = new Status
    status.fromInt(0xde)

    assert(status.asInt() === 0xde)

  }

}
