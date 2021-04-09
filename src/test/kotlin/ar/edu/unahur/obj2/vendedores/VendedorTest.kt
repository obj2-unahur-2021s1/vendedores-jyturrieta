package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class VendedorTest : DescribeSpec({
  val misiones = Provincia(1300000)
  val sanIgnacio = Ciudad(misiones)
  val cordoba = Provincia(2000000)
  val rioCeballos = Ciudad(cordoba)
  val altaGracia = Ciudad(cordoba)
  val mendoza = Provincia(1800000)
  val sanRafael = Ciudad(mendoza)
  val guaymallen = Ciudad(mendoza)
  val buenosAires = Provincia(150000000)
  val hurlingham = Ciudad(buenosAires)
  val laPlata = Ciudad(buenosAires)



  describe("Vendedor fijo") {
    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(obera)
    val vendedorFijo1 = VendedorFijo(rioCeballos)
    val vendedorFijo2 = VendedorFijo(laPlata)
    val vendedorFijo3 = VendedorFijo(guaymallen)
    describe("puedeTrabajarEn") {
      it("su ciudad de origen") {
        vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
        vendedorFijo1.puedeTrabajarEn(rioCeballos).shouldBeTrue()
        vendedorFijo2.puedeTrabajarEn(laPlata).shouldBeTrue()
        vendedorFijo3.puedeTrabajarEn(guaymallen).shouldBeTrue()
      }
      it("otra ciudad") {
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
        vendedorFijo1.puedeTrabajarEn(altaGracia).shouldBeFalse()
        vendedorFijo2.puedeTrabajarEn(hurlingham).shouldBeFalse()
        vendedorFijo3.puedeTrabajarEn(sanRafael).shouldBeFalse()
      }
      it("esInfluyente")
      {
        vendedorFijo.esInfluyente().shouldBeFalse()
      }
    }
  }

  describe("Viajante") {
    val cordoba = Provincia(2000000)
    val villaDolores = Ciudad(cordoba)
    val viajante = Viajante(listOf(misiones))
    val viajante1 = Viajante(listOf(buenosAires))

    describe("puedeTrabajarEn") {
      it("una ciudad que pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(villaDolores).shouldBeFalse()
      }
      it("viajante es influyente")
      {
        viajante.esInfluyente().shouldBeFalse()
        viajante1.esInfluyente().shouldBeTrue()
      }
    }
  }
})
