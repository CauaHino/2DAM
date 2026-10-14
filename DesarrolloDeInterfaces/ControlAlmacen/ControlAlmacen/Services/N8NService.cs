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

    public N8NService() {}

    public async Task EnviarImagen(IStorageFile imagen)
    {
        using var cliente = new HttpClient();   
        using var contenido = new MultipartFormDataContent();

        await using var stream = await imagen.OpenReadAsync();
        var archivo = new StreamContent(stream);

        archivo.Headers.ContentType = new MediaTypeHeaderValue("imagen/jpeg");
        contenido.Add(archivo, "imagen", imagen.Name);
        
        await cliente.PostAsync(url+"/imagen", contenido);
    }
    
    public async Task EnviarImagenes(IStorageFile imagen, Guid idProducto)
    {
        using var cliente = new HttpClient();   
        using var contenido = new MultipartFormDataContent();

        await using var stream = await imagen.OpenReadAsync();
        var archivo = new StreamContent(stream);

        archivo.Headers.ContentType = new MediaTypeHeaderValue("imagen/jpeg");
        contenido.Add(archivo, "imagen", imagen.Name);
        
        await cliente.PostAsync(url+"/imagenes/?uuidProducto="+idProducto, contenido);
    }

    public async Task<AvaloniaList<string>> ObtenerImagenes(Guid uuidProducto)
    {
        using var cliente = new HttpClient();
        var listaJson = await cliente.GetFromJsonAsync<JsonElement>(url+"/lista/?uuidProducto="+uuidProducto);
        var elementos = listaJson.EnumerateArray().ToArray();
        AvaloniaList<string> listaUrlImagenes = new();
        foreach (var elemento in elementos)
        {
            string urlImagen = url + "/imagenes?uuidProducto="+ uuidProducto + "&nombre=" + elemento.GetProperty("name").GetString();
            listaUrlImagenes.Add(urlImagen);
        } 
        return listaUrlImagenes;
    }
    
}