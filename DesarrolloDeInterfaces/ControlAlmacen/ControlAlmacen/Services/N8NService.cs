using System;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Text.Json;
using System.Threading.Tasks;
using Avalonia.Collections;
using Avalonia.Platform.Storage;
using ControlAlmacen.Models;

namespace ControlAlmacen.Services;

public class N8NService
{
    private HttpClient Client = new HttpClient();
    private string url = "http://192.168.29.12:11078/webhook";

    public N8NService()
    {
    }

    public async Task<Guid> crearProducto(Componente componente)
    {
        using var cliente = new HttpClient();
        var response = await cliente.PostAsJsonAsync(url + "/crearProducto", componente);
        response.EnsureSuccessStatusCode();
        var json = await response.Content.ReadFromJsonAsync<JsonElement>();
        Guid uuidProducto = json.GetProperty("id").GetGuid();
        return uuidProducto;
    }

    public async Task EnviarImagen(IStorageFile imagen)
    {
        using var cliente = new HttpClient();
        using var contenido = new MultipartFormDataContent();

        await using var stream = await imagen.OpenReadAsync();
        var archivo = new StreamContent(stream);

        archivo.Headers.ContentType = new MediaTypeHeaderValue("imagen/jpeg");
        contenido.Add(archivo, "imagen", imagen.Name);

        await cliente.PostAsync(url + "/imagen", contenido);
    }

    public async Task EnviarImagenes(IStorageFile imagen, Guid idProducto)
    {
        using var contenido = new MultipartFormDataContent();

        await using var stream = await imagen.OpenReadAsync();
        var archivo = new StreamContent(stream);

        archivo.Headers.ContentType = new MediaTypeHeaderValue("imagen/jpeg");
        contenido.Add(archivo, "imagen", imagen.Name);

        await Client.PostAsync(url + "/imagenes/?uuidProducto=" + idProducto, contenido);
    }

    public async Task<AvaloniaList<string>> ObtenerImagenes(Guid uuidProducto)
    {
        using var cliente = new HttpClient();
        var listaJson = await cliente.GetFromJsonAsync<JsonElement>(url + "/lista/?uuidProducto=" + uuidProducto);
        var elementos = listaJson.EnumerateArray().ToArray();
        AvaloniaList<string> listaUrlImagenes = new();
        foreach (var elemento in elementos)
        {
            string urlImagen = url + "/imagenes?uuidProducto=" + uuidProducto + "&nombre=" +
                               elemento.GetProperty("name").GetString();
            listaUrlImagenes.Add(urlImagen);
        }

        return listaUrlImagenes;
    }

    public async Task<AvaloniaList<Proveedor>> SelectProveedores()
    {
        using var cliente = new HttpClient();
        var listaJson = await cliente.GetFromJsonAsync<JsonElement>(url + "/selectProveedores/");
        var elementos = listaJson.EnumerateArray().ToArray();
        AvaloniaList<Proveedor> proveedores = new();
        foreach (var proveedor in elementos)
        {
            proveedores.Add(new Proveedor
            {
                idProveedor = proveedor.GetProperty("id").GetGuid(),
                nombre =  proveedor.GetProperty("nombre").GetString()
            });
        }

        return proveedores;
    }
    
    public async Task<AvaloniaList<Componente>> SelectProductos()
    {
        using var cliente = new HttpClient();
        var listaJson = await cliente.GetFromJsonAsync<JsonElement>(url + "/selectProductos/");
        var elementos = listaJson.EnumerateArray().ToArray();
        AvaloniaList<Componente> productos = new();
        foreach (var producto in elementos)
        {
            productos.Add(new Componente
            {
                Id = producto.GetProperty("id").GetGuid(),
                Nombre = producto.GetProperty("nombre").GetString(),
                Descripcion =  producto.GetProperty("descripcion").GetString(),
                Activo =  producto.GetProperty("activo").GetBoolean(),
                Codigo = producto.GetProperty("codigo").GetString(),
                FechaAlta =  producto.GetProperty("fecha_alta").GetDateTime(),
                Stock = producto.GetProperty("stock").GetInt32(),
                PrecioVenta = decimal.Parse(producto.GetProperty("precio_venta").GetString())
            });
        }

        return productos;
    }
}