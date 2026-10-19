using System;

namespace ControlAlmacen.Models;

public class Proveedor
{
    public Guid idProveedor { get; set; }
    public string? nombre { get; set; }

    public override string ToString()
    {
        return nombre;
    }
}