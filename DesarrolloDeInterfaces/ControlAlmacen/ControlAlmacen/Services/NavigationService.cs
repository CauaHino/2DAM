using Avalonia.Collections;
using CommunityToolkit.Mvvm.ComponentModel;
using ControlAlmacen.ViewModels;

namespace ControlAlmacen.Services;

public partial class NavigationService : ObservableObject
{
    [ObservableProperty] private ViewModelBase _vistaActual;
    public AvaloniaList<ViewModelBase> ListaVistas { get; } = new() ;

    public void Navegar(string titulo)
    {
        foreach (var vista in ListaVistas)
        {
            if (vista.Titulo == titulo)
            {
                VistaActual = vista;
                return;
            }
        }
    }
}