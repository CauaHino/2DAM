using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Json;
using System.Threading.Tasks;
using Almacen.Models;
using Avalonia.Collections;

namespace Almacen.Services;

public class N8NService
{
    private HttpClient Client = new HttpClient();
    private string url = "http://192.168.29.12:11078/webhook";

    public N8NService() {}

    public async Task CrearComponente(Componente componente)
    {
        await Client.PostAsJsonAsync(url+"/crearComponente", componente);
    }

    public async Task<AvaloniaList<Componente>> ConsultarComponentes()
    {
        return await Client.GetFromJsonAsync<AvaloniaList<Componente>>(url + "/selectComponentes");
    }


}