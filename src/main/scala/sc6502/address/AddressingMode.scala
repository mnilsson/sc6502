package sc6502.address

sealed abstract class AddressingMode

case class Absolute() extends AddressingMode

case class AbsoluteIndirect() extends AddressingMode
case class AbsoluteX() extends AddressingMode
case class AbsoluteY() extends AddressingMode

case class Immediate() extends AddressingMode


case class ZeroPage() extends AddressingMode
case class ZeroPageX() extends AddressingMode
case class ZeroPageY() extends AddressingMode
case class IndexedIndirectX() extends AddressingMode
case class IndirectIndexedY() extends AddressingMode
case class Accumulator() extends AddressingMode
case class Implicit() extends AddressingMode
