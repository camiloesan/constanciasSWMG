package com.swmg.constanciasswmg.utils;

import com.swmg.constanciasswmg.pojo.ParticipacionEE;
import com.swmg.constanciasswmg.pojo.Pladea;
import com.swmg.constanciasswmg.pojo.Proyecto;
import javafx.scene.control.Alert;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GenerarPDF {

    public void GenerarConstanciaPladea(Pladea pladea, String nombreDocente){
        String inputPdf = "src/main/Plantillas/PlantillaPladea.pdf";
        String outputPdf = "src/main/Plantillas/PlantillaPladeaLleno.pdf";

        try (PDDocument document = PDDocument.load(new File(inputPdf))) {
            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

            if (acroForm != null) {
                // Ejemplo de relleno
                PDField trabajadorField = acroForm.getField("NombreProfesor"); // Cambia "nombreCampo1"
                if (trabajadorField != null) {
                    trabajadorField.setValue(nombreDocente);
                }
                PDField ejeEstrategicoField = acroForm.getField("EjeEstrategico"); // Cambia "nombreCampo1"
                if (ejeEstrategicoField != null) {
                    ejeEstrategicoField.setValue(pladea.getEjeEstrategico());
                }
                PDField planEstrategicoField = acroForm.getField("PlanEstrategico"); // Cambia "nombreCampo1"
                if (planEstrategicoField != null) {
                    planEstrategicoField.setValue(pladea.getNombrePrograma());
                }
                PDField objetivosGeneralesField = acroForm.getField("ObjetivosGenerales"); // Cambia "nombreCampo1"
                if (objetivosGeneralesField != null) {
                    objetivosGeneralesField.setValue(pladea.getObjetivosGenerales());
                }
                PDField accionesField = acroForm.getField("Acciones"); // Cambia "nombreCampo1"
                if (accionesField != null) {
                    accionesField.setValue(pladea.getAcciones());
                }
                PDField metasField = acroForm.getField("Metas"); // Cambia "nombreCampo1"
                if (metasField != null) {
                    metasField.setValue(pladea.getMetas());
                }
            }

            document.save(outputPdf);
            System.out.println("Formulario llenado guardado en: " + outputPdf);
            mostrarAlertaRegistroExitoso();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void GenerarConstanciaEE(ParticipacionEE participacionEE, String nombreDocente) {
        String inputPdf = "src/main/Plantillas/PlantillaParticipacionEE.pdf";
        String outputPdf = "src/main/Plantillas/PlantillaParticipacionEELleno.pdf";

        try (PDDocument document = PDDocument.load(new File(inputPdf))) {
            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

            if (acroForm != null) {
                // Ejemplo de relleno
                PDField trabajadorField = acroForm.getField("NombreProfesor"); // Cambia "nombreCampo1"
                if (trabajadorField != null) {
                    trabajadorField.setValue(nombreDocente);
                }
                PDField nombreEEField = acroForm.getField("NombreEE"); // Cambia "nombreCampo1"
                if (nombreEEField != null) {
                    nombreEEField.setValue(participacionEE.getNombreEe());
                }
                PDField programaEEField = acroForm.getField("ProgramaEE"); // Cambia "nombreCampo1"
                if (programaEEField != null) {
                    programaEEField.setValue(participacionEE.getPrograma());
                }
                PDField bloqueEEField = acroForm.getField("BloqueEE"); // Cambia "nombreCampo1"
                if (bloqueEEField != null) {
                    bloqueEEField.setValue(participacionEE.getBloque());
                }
                PDField fechaField = acroForm.getField("Fecha"); // Cambia "nombreCampo1"
                if (fechaField != null) {
                    LocalDate fechaHoy = LocalDate.now();

                    // Define un formato (por ejemplo, dd/MM/yyyy)
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    // Convierte la fecha a String con el formato definido
                    String fechaHoyStr = fechaHoy.format(formatter);
                    fechaField.setValue(fechaHoyStr);
                }
            }

            document.save(outputPdf);
            System.out.println("Formulario llenado guardado en: " + outputPdf);
            mostrarAlertaRegistroExitoso();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void GenerarConstanciaProyecto(Proyecto proyecto, String nombreDocente) {
        String inputPdf = "src/main/Plantillas/PlantillaProyecto.pdf";
        String outputPdf = "src/main/Plantillas/PlantillaProyectoLleno.pdf";

        try (PDDocument document = PDDocument.load(new File(inputPdf))) {
            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

            if (acroForm != null) {
                // Ejemplo de relleno
                PDField trabajadorField = acroForm.getField("NombreDocente"); // Cambia "nombreCampo1"
                if (trabajadorField != null) {
                    trabajadorField.setValue(nombreDocente);
                }
                PDField nombreProyectoField = acroForm.getField("NombreProyecto"); // Cambia "nombreCampo1"
                if (nombreProyectoField != null) {
                    nombreProyectoField.setValue(proyecto.getNombreProyecto());
                }
                PDField duracionProyectoField = acroForm.getField("DuracionProyecto"); // Cambia "nombreCampo1"
                if (duracionProyectoField != null) {
                    duracionProyectoField.setValue(proyecto.getDuracion());
                }
                PDField lugarProyectoField = acroForm.getField("LugarProyecto"); // Cambia "nombreCampo1"
                if (lugarProyectoField != null) {
                    lugarProyectoField.setValue(proyecto.getLugar());
                }
            }

            document.save(outputPdf);
            System.out.println("Formulario llenado guardado en: " + outputPdf);
            mostrarAlertaRegistroExitoso();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void mostrarAlertaRegistroExitoso() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Registro Exitoso");
        alerta.setHeaderText(null); // Opcional: puedes agregar un encabezado o dejarlo en null
        alerta.setContentText("El registro se ha completado con éxito.");
        alerta.showAndWait(); // Muestra la alerta y espera a que el usuario la cierre
    }
}
