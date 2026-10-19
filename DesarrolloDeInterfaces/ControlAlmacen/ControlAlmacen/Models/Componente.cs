using System;
using System.Text.Json.Serialization;
using CommunityToolkit.Mvvm.ComponentModel;

namespace ControlAlmacen.Models;

public partial class Componente : ObservableObject
{
   public Guid Id { get; set; }
   public string Nombre { get; set; }
   public string Descripcion { get; set; }
   public string Codigo { get; set; }
   [JsonPropertyName("precio_venta")]  public decimal PrecioVenta { get; set; }
   public int Stock { get; set; }
   public bool activo { get; set; } = true;
   [JsonPropertyName("fecha_alta")] public DateTime FechaAlta { get; set; } =  DateTime.Now;
}