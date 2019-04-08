package sc6502

import sc6502.address.AddressingMode

sealed abstract class Instruction


case class Aac(addressingMode: AddressingMode) extends Instruction
case class Adc(addressingMode: AddressingMode) extends Instruction
case class And(addressingMode: AddressingMode) extends Instruction
case class Arr(addressingMode: AddressingMode) extends Instruction
case class Asl(addressingMode: AddressingMode) extends Instruction
case class Asr(addressingMode: AddressingMode) extends Instruction
case class Atx(addressingMode: AddressingMode) extends Instruction
case class Axs(addressingMode: AddressingMode) extends Instruction
case class Bcc() extends Instruction
case class Bcs() extends Instruction
case class Beq() extends Instruction
case class Bit(addressingMode: AddressingMode) extends Instruction
case class Bmi() extends Instruction
case class Bne() extends Instruction
case class Bpl() extends Instruction
case class Brk() extends Instruction
case class Bvc() extends Instruction
case class Bvs() extends Instruction
case class Clc() extends Instruction
case class Cld() extends Instruction
case class Cli() extends Instruction
case class Clv() extends Instruction
case class Cmp(addressingMode: AddressingMode) extends Instruction
case class Cpx(addressingMode: AddressingMode) extends Instruction
case class Cpy(addressingMode: AddressingMode) extends Instruction
case class Dcp(addressingMode: AddressingMode) extends Instruction
case class Dec(addressingMode: AddressingMode) extends Instruction
case class Dex() extends Instruction
case class Dey() extends Instruction
case class Eor(addressingMode: AddressingMode) extends Instruction
case class Inc(addressingMode: AddressingMode) extends Instruction
case class Inx() extends Instruction
case class Iny() extends Instruction
case class Isc(addressingMode: AddressingMode) extends Instruction
case class Jmp(addressingMode: AddressingMode) extends Instruction
case class Jsr(addressingMode: AddressingMode) extends Instruction
case class Lax(addressingMode: AddressingMode) extends Instruction
case class Lda(addressingMode: AddressingMode) extends Instruction
case class Ldx(addressingMode: AddressingMode) extends Instruction
case class Ldy(addressingMode: AddressingMode) extends Instruction
case class Lsr(addressingMode: AddressingMode) extends Instruction
case class Nop() extends Instruction
case class Ora(addressingMode: AddressingMode) extends Instruction
case class Pha() extends Instruction
case class Php() extends Instruction
case class Pla() extends Instruction
case class Plp() extends Instruction
case class Rla(addressingMode: AddressingMode) extends Instruction
case class Rol(addressingMode: AddressingMode) extends Instruction
case class Ror(addressingMode: AddressingMode) extends Instruction
case class Rra(addressingMode: AddressingMode) extends Instruction
case class Rti() extends Instruction
case class Rts() extends Instruction
case class Sax(addressingMode: AddressingMode) extends Instruction
case class Sbc(addressingMode: AddressingMode) extends Instruction
case class Sec() extends Instruction
case class Sed() extends Instruction
case class Sei() extends Instruction
case class Slo(addressingMode: AddressingMode) extends Instruction
case class Sre(addressingMode: AddressingMode) extends Instruction
case class Sta(addressingMode: AddressingMode) extends Instruction
case class Stx(addressingMode: AddressingMode) extends Instruction
case class Sty(addressingMode: AddressingMode) extends Instruction
case class Tax() extends Instruction
case class Tay() extends Instruction
case class Tsx() extends Instruction
case class Txa() extends Instruction
case class Txs() extends Instruction
case class Tya() extends Instruction
case class UnofficialNop(addressingMode: AddressingMode) extends Instruction


