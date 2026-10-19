using CommunityToolkit.Mvvm.ComponentModel;
using ControlAlmacen.Services;

namespace ControlAlmacen.ViewModels;

public partial class MainViewModel : ViewModelBase
{
    public NavigationService NavigationService { get; } = new();
    private N8NService _n8nService { get; } = new();

    public MainViewModel()
    {
        NavigationService.ListaVistas.Add(new HomeViewModel(NavigationService));
        NavigationService.ListaVistas.Add(new AltaComponenteViewModel(NavigationService, _n8nService));
        NavigationService.ListaVistas.Add(new ConsultasViewModel(NavigationService,  _n8nService));
        NavigationService.Navegar(Titulo);
    }
    
}