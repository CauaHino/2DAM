namespace Almacen.Models;

public class Componente
{
    public string Categoria { get; set; } = string.Empty;
    public string Nombre { get; set; } = string.Empty;
    public string Descripcion { get; set; } = string.Empty;
    public int Cantidad { get; set; } = 0;
    public bool Disponible { get; set; } = false;
}