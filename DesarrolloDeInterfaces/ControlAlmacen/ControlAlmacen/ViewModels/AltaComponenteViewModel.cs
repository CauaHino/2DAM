using System;
using System.Threading.Tasks;
using Avalonia.Collections;
using Avalonia.Media.Imaging;
using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using ControlAlmacen.Models;
using ControlAlmacen.Services;
using MsBox.Avalonia;
using MsBox.Avalonia.Enums;

namespace ControlAlmacen.ViewModels;

public partial class AltaComponenteViewModel : ViewModelBase
{
   private FilePickerService _filePickerService = new FilePickerService();
   private N8NService _n8nService = new();
   
   [ObservableProperty] private bool _mostrarImagen;
   [ObservableProperty] private Bitmap? _imagen;
   
   [RelayCommand]
   public async Task SeleccionarImagen()
   {
      var imagenPicker = await _filePickerService.SeleccionarImagen();
      if (imagenPicker == null)
      {
         return;
      }
      MostrarImagen = true;
      await using var stream = await imagenPicker.OpenReadAsync();
      Imagen = new Bitmap(stream);
      var uuidProducto = Guid.Parse("c9d7f5a1-2235-4b9f-b424-103a9e233d72");
      _n8nService.EnviarImagenes(imagenPicker, uuidProducto);
   }
}