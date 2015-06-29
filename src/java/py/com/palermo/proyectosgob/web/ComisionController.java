package py.com.palermo.proyectosgob.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import py.com.palermo.proyectosgob.dao.ComisionFacade;
import py.com.palermo.proyectosgob.persistencia.Comision;
import py.com.palermo.proyectosgob.persistencia.Miembro;
import py.com.palermo.proyectosgob.web.util.JsfUtil;

@Named("comisionController")
@ViewScoped
public class ComisionController implements Serializable {

    @EJB
    private ComisionFacade ejbFacade;
    private List<Comision> itemsDiputados = null;
    private List<Comision> itemsSenadores = null;
    private Comision selected;
    private Miembro miembroNuevo;
    private long id;

    public boolean haySeleccion() {
        boolean R = false;

        if (selected != null && selected.getId() != null && selected.getId() > 0) {
            R = true;
        }
        return R;
    }

    public void cargaDatos() {
        if (id > 0) {
            selected = ejbFacade.find(id);
        }
    }

    public Miembro getMiembroNuevo() {
        if (miembroNuevo == null) {
            miembroNuevo = new Miembro();
            miembroNuevo.setComision(selected);
        }
        return miembroNuevo;
    }

    public void setMiembroNuevo(Miembro miembroNuevo) {
        this.miembroNuevo = miembroNuevo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ComisionController() {
    }

    public Comision getSelected() {
        if (selected == null) {
            selected = new Comision();
            initializeEmbeddableKey();
        }
        return selected;
    }

    public void setSelected(Comision selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ComisionFacade getFacade() {
        return ejbFacade;
    }

    public String guardar() {
        try {
            ejbFacade.edit(selected);
            JsfUtil.addSuccessMessage("La comisión se guardo exitosamente!");
        } catch (Exception e) {

        }
        return "List.xhtml?faces-redirect=true";
    }

    public void remover() {
        try {
            ejbFacade.remover(selected);
            JsfUtil.addSuccessMessage("La comisión se eliminó exitosamente!");
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e.getMessage());
        }

    }

    public void addMiembro() {
        if (selected.getMiembros() == null) {
            selected.setMiembros(new ArrayList<Miembro>());
        }
        miembroNuevo.setComision(selected);
        selected.getMiembros().add(miembroNuevo);
        miembroNuevo = null;
    }

    public void removeMiembro(Miembro m) {
        int index = 0;
        for (Miembro m2 : selected.getMiembros()) {
            if (m.getNombre().compareToIgnoreCase(m2.getNombre()) == 0) {
                break;
            }
            index++;
        }

        selected.getMiembros().remove(index);
    }

    public Comision prepareCreate() {

        initializeEmbeddableKey();
        return selected;
    }

    public List<Comision> getItemsDiputados() {
        if (itemsDiputados == null) {
            itemsDiputados = getFacade().findPorCamara("CAMARA DE DIPUTADOS");
        }
        return itemsDiputados;
    }

    public List<Comision> getItemsSenadores() {
        if (itemsSenadores == null) {
            itemsSenadores = getFacade().findPorCamara("CAMARA DE SENADORES");
        }
        return itemsSenadores;
    }

    public Comision getComision(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Comision> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Comision> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Comision.class)
    public static class ComisionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComisionController controller = (ComisionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comisionController");
            return controller.getComision(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Comision) {
                Comision o = (Comision) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Comision.class.getName()});
                return null;
            }
        }

    }

}
