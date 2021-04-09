package ar.edu.unahur.obj2.vendedores
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class centroDistribucionTest: DescribeSpec({
    val misiones = Provincia(1300000)
    val obera = Ciudad(misiones)
    val cordoba = Provincia(2000000)
    val villaDolores = Ciudad(cordoba)
    val buenosAires = Provincia(17000000)
    val hurlingham = Ciudad(buenosAires)


    val vendedorFijo = VendedorFijo(obera)

    val viajante1 = Viajante(listOf(cordoba, misiones))
    val viajante2 = Viajante(listOf(cordoba))
    val viajante3 = Viajante(listOf(cordoba))

    val certificacion1 = Certificacion(false, 10)
    val certificacion2 = Certificacion(true, 9)
    val certificacion3 = Certificacion(false, 15)
    val certificacion4 = Certificacion(true, 20)
    val certificacion5 = Certificacion(false, 14)
    val certificacion6 = Certificacion(true, 21)
    val certificacion7 = Certificacion(false, 18)
    val certificacion8 = Certificacion(true, 13)
    val certificacion9 = Certificacion(false, 16)
    val certificacion10 = Certificacion(true, 47)
    val certificacion11 = Certificacion(false, 17)
    val certificacion12 = Certificacion(true, 12)

    val centroDistribucion1 = CentroDeDistribucion(obera)
    val centroDistribucion2 = CentroDeDistribucion(villaDolores)

    centroDistribucion1.agregarVendedor(vendedorFijo)
    centroDistribucion1.agregarVendedor(viajante1)

    viajante1.agregarCertificacion(certificacion1)
    viajante1.agregarCertificacion(certificacion2)
    viajante1.agregarCertificacion(certificacion3)
    viajante1.agregarCertificacion(certificacion4)

    viajante2.agregarCertificacion(certificacion5)
    viajante2.agregarCertificacion(certificacion6)
    viajante2.agregarCertificacion(certificacion7)
    viajante2.agregarCertificacion(certificacion8)

    viajante3.agregarCertificacion(certificacion9)
    viajante3.agregarCertificacion(certificacion10)
    viajante3.agregarCertificacion(certificacion11)
    viajante3.agregarCertificacion(certificacion12)

    centroDistribucion2.agregarVendedor(viajante1)
    centroDistribucion2.agregarVendedor(viajante2)
    centroDistribucion2.agregarVendedor(viajante3)

    describe("Centro Distribucion"){
        it("Vendedor Estrella")
        {
            centroDistribucion1.vendedorEstrella().shouldBe(viajante1)
            centroDistribucion2.vendedorEstrella().shouldBe(viajante3)
        }
        it("puede cubrir")
        {
            centroDistribucion1.puedeCubrir(villaDolores).shouldBeTrue()
            centroDistribucion2.puedeCubrir(hurlingham).shouldBeFalse()
        }
        it ("Vendedores genericos")
        {
            centroDistribucion1.vendedoresGenericos().shouldBe(listOf(viajante1))
            centroDistribucion2.vendedoresGenericos().shouldBe(listOf(viajante1, viajante2, viajante3))
        }
        it ("Es robusto")
        {
            centroDistribucion1.esRobusto().shouldBeFalse()
            centroDistribucion2.esRobusto().shouldBeTrue()
        }
    }
})