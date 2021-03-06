package core

import chisel3._

class ByPassBridgeTests(c: ByPassBridge) extends PeekPokeTester(c) {
  
	
	printf("%b",BEQ)
}

class ByPassBridgeTester extends ChiselFlatSpec {
  behavior of "ByPassBridge"
  backends foreach {backend =>    it should s"correctly add randomly generated numbers $backend" in {
      Driver(() => new ByPassBridge())(c => new ByPassBridgeTests(c)) should be (true)
    }
  }
}
