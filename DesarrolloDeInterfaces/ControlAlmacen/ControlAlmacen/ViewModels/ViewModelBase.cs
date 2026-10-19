using CommunityToolkit.Mvvm.ComponentModel;
using Material.Icons;

namespace ControlAlmacen.ViewModels;

public abstract class ViewModelBase : ObservableObject
{
    public string Titulo { get; set; }
    public MaterialIconKind Icon { get; set; }
}