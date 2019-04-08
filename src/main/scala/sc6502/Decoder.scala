package sc6502

import sc6502.address._

object Decoder {
 def decode(opcode: Int) : Instruction = {
  opcode match {
   case 0x69 => Adc(new Immediate)
   case 0x65 => Adc(new ZeroPage)
   case 0x75 => Adc(new ZeroPageX)
   case 0x6d => Adc(new Absolute)
   case 0x7d => Adc(new AbsoluteX)
   case 0x79 => Adc(new AbsoluteY)
   case 0x61 => Adc(new IndexedIndirectX)
   case 0x71 => Adc(new IndirectIndexedY)


   case 0x29 => And(new Immediate)
   case 0x25 => And(new ZeroPage)
   case 0x35 => And(new ZeroPageX)
   case 0x2d => And(new Absolute)
   case 0x3d => And(new AbsoluteX)
   case 0x39 => And(new AbsoluteY)
   case 0x21 => And(new IndexedIndirectX)
   case 0x31 => And(new IndirectIndexedY)

   case 0x0a => Asl(new Accumulator)
   case 0x06 => Asl(new ZeroPage)
   case 0x16 => Asl(new ZeroPageX)
   case 0x0e => Asl(new Absolute)
   case 0x1e => Asl(new AbsoluteX)

   case 0x90 => Bcc()

   case 0xb0 => Bcs()

   case 0xf0 => Beq()

   case 0x24 => Bit(new ZeroPage)
   case 0x2c => Bit(new Absolute)

   case 0xc9 => Cmp(new Immediate)
   case 0xc5 => Cmp(new ZeroPage)
   case 0xd5 => Cmp(new ZeroPageX)
   case 0xcd => Cmp(new Absolute)
   case 0xdd => Cmp(new AbsoluteX)
   case 0xd9 => Cmp(new AbsoluteY)
   case 0xc1 => Cmp(new IndexedIndirectX)
   case 0xd1 => Cmp(new IndirectIndexedY)

   case 0x49 => Eor(new Immediate)
   case 0x45 => Eor(new ZeroPage)
   case 0x55 => Eor(new ZeroPageX)
   case 0x4d => Eor(new Absolute)
   case 0x5d => Eor(new AbsoluteX)
   case 0x59 => Eor(new AbsoluteY)
   case 0x41 => Eor(new IndexedIndirectX)
   case 0x51 => Eor(new IndirectIndexedY)

   case 0x4a => Lsr(new Accumulator)
   case 0x46 => Lsr(new ZeroPage)
   case 0x56 => Lsr(new ZeroPageX)
   case 0x4e => Lsr(new Absolute)
   case 0x5e => Lsr(new AbsoluteX)

   case 0xa1 => Lda(new IndexedIndirectX)
   case 0xa5 => Lda(new ZeroPage)
   case 0xa9 => Lda(new Immediate)
   case 0xad => Lda(new Absolute)
   case 0xb1 => Lda(new IndirectIndexedY)
   case 0xb5 => Lda(new ZeroPageX)
   case 0xb9 => Lda(new AbsoluteY)
   case 0xbd => Lda(new AbsoluteX)

   case 0xa0 => Ldy(new Immediate)
   case 0xa4 => Ldy(new ZeroPage)
   case 0xb4 => Ldy(new ZeroPageX)
   case 0xac => Ldy(new Absolute)
   case 0xbc => Ldy(new AbsoluteX)

   case 0xa2 => Ldx(new Immediate)
   case 0xa6 => Ldx(new ZeroPage)
   case 0xb6 => Ldx(new ZeroPageY)
   case 0xae => Ldx(new Absolute)
   case 0xbe => Ldx(new AbsoluteY)

   case 0x30 => Bmi()
   case 0xd0 => Bne()
   case 0x10 => Bpl()

   case 0x00 => Brk()

   case 0x50 => Bvc()
   case 0x70 => Bvs()

   case 0x09 => Ora(new Immediate)
   case 0x0d => Ora(new Absolute)
   case 0x05 => Ora(new ZeroPage)
   case 0x15 => Ora(new ZeroPageX)
   case 0x0d => Ora(new Absolute)
   case 0x1d => Ora(new AbsoluteX)
   case 0x19 => Ora(new AbsoluteY)
   case 0x01 => Ora(new IndexedIndirectX)
   case 0x11 => Ora(new IndirectIndexedY)

   case 0x6a => Ror(new Accumulator)
   case 0x66 => Ror(new ZeroPage)
   case 0x76 => Ror(new ZeroPageX)
   case 0x6e => Ror(new Absolute)
   case 0x7e => Ror(new AbsoluteX)

   case 0xe9 => Sbc(new Immediate)
   case 0xeb => Sbc(new Immediate) //illegal/unofficial
   case 0xe5 => Sbc(new ZeroPage)
   case 0xf5 => Sbc(new ZeroPageX)
   case 0xed => Sbc(new Absolute)
   case 0xfd => Sbc(new AbsoluteX)
   case 0xf9 => Sbc(new AbsoluteY)
   case 0xe1 => Sbc(new IndexedIndirectX)
   case 0xf1 => Sbc(new IndirectIndexedY)

   case 0x85 => Sta(new ZeroPage)
   case 0x95 => Sta(new ZeroPageX)
   case 0x8d => Sta(new Absolute)
   case 0x9d => Sta(new AbsoluteX)
   case 0x99 => Sta(new AbsoluteY)
   case 0x81 => Sta(new IndexedIndirectX)
   case 0x91 => Sta(new IndirectIndexedY)

   case 0x84 => Sty(new ZeroPage)
   case 0x94 => Sty(new ZeroPageX)
   case 0x8c => Sty(new Absolute)

   case 0x86 => Stx(new ZeroPage)
   case 0x96 => Stx(new ZeroPageY)
   case 0x8e => Stx(new Absolute)

   case 0x88 => Dey()
   case 0xca => Dex()

   case 0xe0 => Cpx(new Immediate)
   case 0xe4 => Cpx(new ZeroPage)
   case 0xec => Cpx(new Absolute)

   case 0xc0 => Cpy(new Immediate)
   case 0xc4 => Cpy(new ZeroPage)
   case 0xcc => Cpy(new Absolute)

   case 0xe6 => Inc(new ZeroPage)
   case 0xf6 => Inc(new ZeroPageX)
   case 0xee => Inc(new Absolute)
   case 0xfe => Inc(new AbsoluteX)

   case 0xc6 => Dec(new ZeroPage)
   case 0xd6 => Dec(new ZeroPageX)
   case 0xce => Dec(new Absolute)
   case 0xde => Dec(new AbsoluteX)

   case 0x9a => Txs()
   case 0xba => Tsx()
   case 0x8a => Txa()
   case 0x98 => Tya()
   case 0xa8 => Tay()
   case 0xaa => Tax()

   case 0x2a => Rol(new Accumulator)
   case 0x26 => Rol(new ZeroPage)
   case 0x36 => Rol(new ZeroPageX)
   case 0x2e => Rol(new Absolute)
   case 0x3e => Rol(new AbsoluteX)

   case 0x08 => Php()
   case 0x28 => Plp()

   case 0x48 => Pha()
   case 0x68 => Pla()

   case 0x60 => Rts()

   case 0xc8 => Iny()
   case 0xe8 => Inx()

   case 0xea => Nop()
   case 0x00 => Brk()
   case 0x40 => Rti()

   case 0x20 => Jsr(new Absolute)
   case 0x4c => Jmp(new Immediate)
   case 0x6c => Jmp(new AbsoluteIndirect) //jmpi

   case 0x04 => UnofficialNop(new ZeroPage)
   case 0x44 => UnofficialNop(new ZeroPage)
   case 0x64 => UnofficialNop(new ZeroPage)

   case 0x0c => UnofficialNop(new Absolute)

   case 0x14 => UnofficialNop(new ZeroPageX)
   case 0x34 => UnofficialNop(new ZeroPageX)
   case 0x54 => UnofficialNop(new ZeroPageX)
   case 0x74 => UnofficialNop(new ZeroPageX)
   case 0xd4 => UnofficialNop(new ZeroPageX)
   case 0xf4 => UnofficialNop(new ZeroPageX)

   case 0x1a => UnofficialNop(new Implicit)
   case 0x3a => UnofficialNop(new Implicit)
   case 0x5a => UnofficialNop(new Implicit)
   case 0x7a => UnofficialNop(new Implicit)
   case 0xda => UnofficialNop(new Implicit)
   case 0xfa => UnofficialNop(new Implicit)

   case 0x80 => UnofficialNop(new Immediate)
   case 0x82 => UnofficialNop(new Immediate)
   case 0x89 => UnofficialNop(new Immediate)
   case 0xc2 => UnofficialNop(new Immediate)

   case 0xe2 => UnofficialNop(new Immediate)

   case 0x1c => UnofficialNop(new AbsoluteX)
   case 0x3c => UnofficialNop(new AbsoluteX)
   case 0x5c => UnofficialNop(new AbsoluteX)
   case 0x7c => UnofficialNop(new AbsoluteX)
   case 0xdc => UnofficialNop(new AbsoluteX)
   case 0xfc => UnofficialNop(new AbsoluteX)

   case 0x18 => Clc()
   case 0x38 => Sec()
   case 0x58 => Cli()
   case 0x78 => Sei()
   case 0xb8 => Clv()
   case 0xd8 => Cld()
   case 0xf8 => Sed()

   // Unofficial
   case 0xa3 => Lax(new IndexedIndirectX)
   case 0xa7 => Lax(new ZeroPage)
   case 0xaf => Lax(new Absolute)
   case 0xb3 => Lax(new IndirectIndexedY)
   case 0xb7 => Lax(new ZeroPageY)
   case 0xbf => Lax(new AbsoluteY)

   case 0x83 => Sax(new IndexedIndirectX)
   case 0x87 => Sax(new ZeroPageX)
   case 0x8f => Sax(new Absolute)
   case 0x97 => Sax(new ZeroPageY)

   case 0xeb => Sbc(new Immediate)

   case 0xe7 => Isc(new ZeroPage)
   case 0xf7 => Isc(new ZeroPageX)
   case 0xef => Isc(new Absolute)
   case 0xff => Isc(new AbsoluteX)
   case 0xfb => Isc(new AbsoluteY)
   case 0xe3 => Isc(new IndexedIndirectX)
   case 0xf3 => Isc(new IndirectIndexedY)

   case 0xc3 => Dcp(new IndexedIndirectX)
   case 0xc7 => Dcp(new ZeroPage)
   case 0xd3 => Dcp(new IndirectIndexedY)
   case 0xd7 => Dcp(new ZeroPageX)
   case 0xcf => Dcp(new Absolute)
   case 0xdb => Dcp(new AbsoluteY)
   case 0xdf => Dcp(new AbsoluteX)

   case 0x07 => Slo(new ZeroPage)
   case 0x17 => Slo(new ZeroPageX)
   case 0x0f => Slo(new Absolute)
   case 0x1f => Slo(new AbsoluteX)
   case 0x1b => Slo(new AbsoluteY)
   case 0x03 => Slo(new IndexedIndirectX)
   case 0x13 => Slo(new IndirectIndexedY)

   case 0x27 => Rla(new ZeroPage)
   case 0x37 => Rla(new ZeroPageX)
   case 0x2f => Rla(new Absolute)
   case 0x3f => Rla(new AbsoluteX)
   case 0x3b => Rla(new AbsoluteY)
   case 0x23 => Rla(new IndexedIndirectX)
   case 0x33 => Rla(new IndirectIndexedY)

   case 0x47 => Sre(new ZeroPage)
   case 0x57 => Sre(new ZeroPageX)
   case 0x4f => Sre(new Absolute)
   case 0x5f => Sre(new AbsoluteX)
   case 0x5b => Sre(new AbsoluteY)
   case 0x43 => Sre(new IndexedIndirectX)
   case 0x53 => Sre(new IndirectIndexedY)

   case 0x67 => Rra(new ZeroPage)
   case 0x77 => Rra(new ZeroPageX)
   case 0x6f => Rra(new Absolute)
   case 0x7f => Rra(new AbsoluteX)
   case 0x7b => Rra(new AbsoluteY)
   case 0x63 => Rra(new IndexedIndirectX)
   case 0x73 => Rra(new IndirectIndexedY)

   case 0x0b => Aac(new Immediate)
   case 0x2b => Aac(new Immediate)

   case 0x4b => Asr(new Immediate)
   case 0x6b => Arr(new Immediate)
   case 0xab => Atx(new Immediate)
   case 0xcb => Axs(new Immediate)
  }
 }
}
