using Almacen.Models;
using Avalonia.Animation;
using Avalonia.Collections;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;

namespace Almacen.ViewModels;

public partial class MainViewModel : ViewModelBase
{
    public AvaloniaList<string> Categorias { get; set; } = ["Periféricos", "Portatiles", "Consolas"];
    public string Titulo { get; set; } = "Almacen Tecnologico";
    public Componente Componente { get; set; } = new Componente();
    [ObservableProperty]
    private int _selectedTab = 0;

    public MainViewModel()
    {
        // categorias.Add("Periféricos");
        // categorias.Add("Portatiles");
        // categorias.Add("Consoals");
    }

    [RelayCommand]
    public void cambiarTab(string i)
    {
        int number = int.Parse(i);
        
        if (number == 1)
        {
            SelectedTab++;
        } else if (number == 0)
        {
            SelectedTab--;
        }
    }
    
}