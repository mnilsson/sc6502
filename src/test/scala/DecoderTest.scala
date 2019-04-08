import sc6502.{Adc, Decoder}
import sc6502.address.Immediate
import org.scalatest.FunSuite

class DecoderTest extends FunSuite {

  test("testDecode") {
    val instr = Decoder.decode(0x69)
    assert(instr === Adc(new Immediate))
  }

}
