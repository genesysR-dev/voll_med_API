package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

@Table(name="medicos")
@Entity(name="Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefone;
    private String documento;
    private Boolean activo;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DatosRegistroMedico datos) {
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.telefone = datos.telefone();
        this.documento = datos.documento();
        this.activo = true;
        this.especialidad = datos.especialidad();
        this.direccion = new Direccion(datos.direccion());
    }

    public void actualizarDatos(DatosActualizarMedicos datosActualizarMedicos) {
        if (datosActualizarMedicos.nombre() != null){
            this.nombre = datosActualizarMedicos.nombre();
        }
        if (datosActualizarMedicos.documento() != null){
            this.nombre = datosActualizarMedicos.documento();
        }
        if (datosActualizarMedicos.direccion() != null){
            this.direccion = direccion.actualizarDatos(datosActualizarMedicos.direccion());
        }


    }

    public void desactivarMedico() {
        this.activo= false;
    }
}
