using System;
using System.Threading.Tasks;
using Avalonia.Collections;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using ControlAlmacen.Models;
using ControlAlmacen.Services;
using ControlAlmacen.Views.Dialogs;
using DialogHostAvalonia;
using Material.Icons;
using SukiUI.Dialogs;

namespace ControlAlmacen.ViewModels;

public partial class ConsultasViewModel : ViewModelBase
{
    private N8NService _n8nService;
    private NavigationService _navigationService;
    
    [ObservableProperty] private AvaloniaList<string> _listarUrlImagenes = new();
    [ObservableProperty] private AvaloniaList<Proveedor> _listaProveedores = new();
    [ObservableProperty] private AvaloniaList<Componente> _listaProductos = new();
    [ObservableProperty] private Componente _componente;

    public ConsultasViewModel(){}
    public ConsultasViewModel(NavigationService navigationService, N8NService n8nService)
    {
        Titulo = "Ver Productos";
        Icon = MaterialIconKind.EyeOutline;
        _navigationService = navigationService;
        _n8nService = n8nService;
    }

    [RelayCommand]
    public void Navegar(string titulo)
    {
        _navigationService.Navegar(titulo);
    }

    [RelayCommand]
    public async Task ListarImagenes()
    {
        ListarUrlImagenes = await _n8nService.ObtenerImagenes(Guid.Parse("c9d7f5a1-2235-4b9f-b424-103a9e233d72"));
    }
    
    [RelayCommand]
    public async Task ListarProveedores()
    {
        ListaProveedores = await _n8nService.SelectProveedores();
    }
    
    [RelayCommand]
    public async Task ListarProductos()
    {
        ListaProductos = await _n8nService.SelectProductos();
    }

    [RelayCommand]
    public void AbrirDialogProducto()
    {
        DialogHost.Show(new DialogoProducto(), "DialogoProducto");
    }
}