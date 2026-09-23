using System;
using CommunityToolkit.Mvvm.ComponentModel;

namespace Almacen.Models;

public partial class Componente : ObservableObject
{
    [ObservableProperty] string _categoria = string.Empty;
    [ObservableProperty] string _nombre = string.Empty;
    [ObservableProperty] string _referencia = string.Empty;
    [ObservableProperty] string _descripcion = string.Empty;
    [ObservableProperty] int _cantidad = 0;
    [ObservableProperty] bool _disponible = false;
    [ObservableProperty] DateTime _fecha = DateTime.Now;
    [ObservableProperty] double _precio = 0;
}