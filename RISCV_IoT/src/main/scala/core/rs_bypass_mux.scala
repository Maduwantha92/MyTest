package core{
import chisel3._

class rs_bypass_mux extends Module {
  val io = IO(new Bundle {
    val rs 				= Input(UInt(width = 32))
    val bypass 				= Input(UInt(width = 32))
    val rs_bypass_mux_sel 	= Input(UInt(width = 1))
    val to_rs_mux 			= Output(UInt(width = 32))
  })
  io.to_rs_mux := Mux( io.rs_bypass_mux_sel===UInt(1) , io.bypass , io.rs )
}
}
