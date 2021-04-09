package ar.edu.unahur.obj2.vendedores

import java.lang.Exception

class CentroDeDistribucion(val ciudad: Ciudad) {

    val vendedores = mutableListOf<Vendedor>()

    fun agregarVendedor(vendedor: Vendedor) {
        if (!vendedores.contains(vendedor)) {
            vendedores.add(vendedor)
        }
        else {
            throw Exception("El vendedor ya se encuentra registrado")
        }
    }

    fun vendedorEstrella() = vendedores.maxBy { it.puntajeCertificaciones() }

    fun puedeCubrir(ciudad: Ciudad) = vendedores.any{it.puedeTrabajarEn(ciudad)}

    fun vendedoresGenericos() = vendedores.filter{it.esGenerico()}

    fun esRobusto() = vendedores.count{it.esFirme()} >= 3

}
