using Avalonia.Collections;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using ControlAlmacen.Services;
using Material.Icons;

namespace ControlAlmacen.ViewModels;

public partial class HomeViewModel : ViewModelBase
{
    private NavigationService _navigationService;
    
    [ObservableProperty] private AvaloniaList<string> _listarUrlImagenes = new();

    public HomeViewModel(){}
    public HomeViewModel(NavigationService navigationService)
    {
        Titulo = "Home";
        Icon = MaterialIconKind.Home;
        _navigationService = navigationService;
    }

    [RelayCommand]
    public void Navegar(string titulo)
    {
        _navigationService.Navegar(titulo);
    }
    
}