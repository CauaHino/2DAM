using UnityEngine;
using UnityEngine.InputSystem;

public class MovimientoBola : MonoBehaviour
{
    public float fuerza = 25f;
    private Rigidbody rb;

    void Start()
    {
        rb = GetComponent<Rigidbody>();

        if (GravitySensor.current != null)
            InputSystem.EnableDevice(GravitySensor.current);
    }

    void FixedUpdate()
    {
        float x = 0f;
        float z = 0f;

        if (GravitySensor.current != null)
        {
            Vector3 gravedad = GravitySensor.current.gravity.ReadValue();
            x = gravedad.x;
            z = gravedad.y;
        }
        else if (Keyboard.current != null)
        {
            if (Keyboard.current.aKey.isPressed) x = -1f;
            if (Keyboard.current.dKey.isPressed) x = 1f;
            if (Keyboard.current.wKey.isPressed) z = 1f;
            if (Keyboard.current.sKey.isPressed) z = -1f;
        }

        Vector3 direccion = Vector3.ClampMagnitude(new Vector3(x, 0, z), 1f);
        rb.AddForce(direccion * fuerza, ForceMode.Acceleration);
    }
}