package core
import chisel3.iotesters.{PeekPokeTester, Driver, ChiselFlatSpec}

class pc_muxTests(c: pc_mux) extends PeekPokeTester(c) {
  for (s0 <- 0 until 2) {
    for (s1 <- 0 until 2) {
	      val i0 = rnd.nextInt(32)
	      val i1 = rnd.nextInt(32)
	      val i2 = rnd.nextInt(32)
	      val i3 = rnd.nextInt(32)
              poke(c.io.pc_sel, s1 << 1 | s0)
              poke(c.io.pc_4, i0)
              poke(c.io.pc, i1)
              poke(c.io.jmp_br, i2)
              step(1)
              val out = if(s1 == 1) {
                          if (s0 == 1) i0 else i2
                        } else {
                          if (s0 == 1) i1 else i0 
                        }
              expect(c.io.to_pc, out)
    }
  }
}

class pc_muxTester extends ChiselFlatSpec {
  behavior of "pc_mux"
  backends foreach {backend =>    it should s"correctly add randomly generated numbers $backend" in {
      Driver(() => new pc_mux())(c => new pc_muxTests(c)) should be (true)
    }
  }
}
