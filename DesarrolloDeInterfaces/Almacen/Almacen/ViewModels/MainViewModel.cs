using System.Threading.Tasks;
using Almacen.Models;
using Almacen.Services;
using Avalonia.Animation;
using Avalonia.Collections;
using Avalonia.Controls;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using MsBox.Avalonia;
using MsBox.Avalonia.Enums;

namespace Almacen.ViewModels;

public partial class MainViewModel : ViewModelBase
{
    public AvaloniaList<string> Categorias { get; set; } = ["Periféricos", "Portatiles", "Consolas"];
    public string Titulo { get; set; } = "Almacen Tecnologico";
    private N8NService N8NService { get; set; } = new();
    
    [ObservableProperty]
    public Componente _componente = new Componente();
    
    [ObservableProperty]
    private int _selectedTab = 0;
    
    [ObservableProperty]
    private bool _isVisibleBack = true;
    
    [ObservableProperty] private bool _isVisibleNext = true;
    [ObservableProperty] private bool _isVisibleFinish = true;

    public MainViewModel() {}

    private async Task MostrarMensaje(string mensaje)
    {
        var box = MessageBoxManager.GetMessageBoxStandard("AVISO!", mensaje, ButtonEnum.Ok);
        await box.ShowAsync();
    }
    private async Task<bool> MensajeFinalizar()
    {
        var box = MessageBoxManager.GetMessageBoxStandard("AVISO!", "¿Deseas Finalizar la Operación?", ButtonEnum.YesNo);
        var result = await box.ShowAsync();
        if (result == ButtonResult.Yes)
        {
            return true;
        }

        return false;
    }

    [RelayCommand]
    public async void Finalizar()
    {
       bool result = await MensajeFinalizar();
       if (!result)
       {
           await MostrarMensaje("Proceso Cancelado");
       }

       await N8NService.CrearComponente(Componente);
    }

    [RelayCommand]
    public void CambiarTab(string i)
    {
        
        int number = int.Parse(i);
        // Estoy en la primera pestaña
        if (SelectedTab == 0 && number == -1)
        {
            return;
        }
        // Estoy en la ultima pestaña
        if (number == 1 && SelectedTab == 2)
        {
            return;
        }
        SelectedTab+=number;
        
        if (SelectedTab == 0)
        {
            IsVisibleBack = false;
            IsVisibleNext = true;
            IsVisibleFinish = false;
        } else if (SelectedTab == 1)
        {
            IsVisibleBack = true;
            IsVisibleNext = true;
            IsVisibleFinish = false;
        } else if (SelectedTab == 2)
        {
            IsVisibleBack = true;
            IsVisibleNext = false;
            IsVisibleFinish = true;
        }
    }
    
}