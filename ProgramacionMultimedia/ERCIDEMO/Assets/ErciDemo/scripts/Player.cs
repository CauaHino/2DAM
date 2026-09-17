using UnityEngine;

public class Player : MonoBehaviour
{
    // PlayerSpeed
    public float speed = 6f;
    
    // Fuerza de salto
    public float jumpForce = 6f;
    
    // Indicar si el jugador está tocando el suelo
    private bool isGrounded;
    
    // Punto situado debajo del jugador para comprobar si hay suelo
    public Transform groundCheck;
    
    // Tamaño del circulo que comproba si hay suelo
    public float groundRadius = 0.1f;
    
    // Capa que representa el suelo
    public LayerMask groundLayer;
    
    // Movement direction
    private float move;
    
    // Rigidbody of the Player
    private Rigidbody2D rb2D;
    
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        // Save in rb2D the Rigidbody of the player
        rb2D = GetComponent<Rigidbody2D>();
    }

    // Update is called once per frame
    void Update()
    {
        // Capturar movimientos
        move = Input.GetAxisRaw("Horizontal");
        
        // Cambiar la velocidad horizontal del jugador
        rb2D.linearVelocity = new Vector2(move * speed, rb2D.linearVelocity.y);
        
        if (Input.GetButtonDown("Jump") && isGrounded) {
            rb2D.linearVelocity = new Vector2(rb2D.linearVelocity.x, jumpForce);
        }
        
        // Orientación 
        if (move != 0) {
            // Cambia la escala en el valor x
            transform.localScale = new Vector3(Mathf.Sign(move), 1, 1);
        }
    }

    void FixedUpdate()
    {
        isGrounded = Physics2D.OverlapCircle(groundCheck.position, groundRadius, groundLayer);
    }
}
