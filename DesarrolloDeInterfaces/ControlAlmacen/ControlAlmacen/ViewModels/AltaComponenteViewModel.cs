using System;
using System.Threading.Tasks;
using Avalonia.Collections;
using Avalonia.Media.Imaging;
using Avalonia.Platform.Storage;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using ControlAlmacen.Models;
using ControlAlmacen.Services;
using Material.Icons;
using MsBox.Avalonia;
using MsBox.Avalonia.Enums;

namespace ControlAlmacen.ViewModels;

public partial class AltaComponenteViewModel : ViewModelBase
{
   private FilePickerService _filePickerService = new FilePickerService();
   private N8NService _n8nService;
   private NavigationService _navigationService;
   private IStorageFile _imagenPicker;
   
   [ObservableProperty] private bool _mostrarImagen;
   [ObservableProperty] private Bitmap? _imagen;
   
   public AltaComponenteViewModel(){}
   
   public AltaComponenteViewModel(NavigationService navigationService, N8NService n8nService)
   {
      Titulo = "Alta componente";
      Icon = MaterialIconKind.AddCircleOutline;
      _navigationService = navigationService;
      _n8nService = n8nService;
   }
   
   [RelayCommand]
   public void Navegar(string titulo)
   {
      _navigationService.Navegar(titulo);
   }
   
   [RelayCommand]
   public async Task SeleccionarImagen()
   {
      _imagenPicker = await _filePickerService.SeleccionarImagen();
      if (_imagenPicker == null)
      {
         return;
      }
      MostrarImagen = true;
      await using var stream = await _imagenPicker.OpenReadAsync();
      Imagen = new Bitmap(stream);
   }

   [RelayCommand]
   public async Task CrearProducto()
   {
      var producto = new Componente
      {
         Nombre = "Memoria RAM",
         Codigo = "RAM2",
         Descripcion = "Memoria RAM",
         PrecioVenta = 200,
         activo =  true,
         FechaAlta = DateTime.Now
      };
      
      Guid uuid = await _n8nService.crearProducto(producto);
      Console.WriteLine(uuid);
      _n8nService.EnviarImagenes(_imagenPicker, uuid);
   }
}