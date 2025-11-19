package pt.escnaval.exercicios;

import java.util.Objects;

/**
 * Classe Iban — objeto de valor imutável.
 * equals/hashCode baseados em codigo.
 */
public class Iban {
    private final String codigo;
    private final boolean valid;

    public Iban(String codigo) {
        this.codigo = codigo != null ? codigo.trim().toUpperCase() : "";
        this.valid = validar();
    }

    private boolean validar() {
        // Validação simplificada: começa com PT e tem pelo menos 25 caracteres
        if (codigo.length() < 25) return false;
        if (!codigo.startsWith("PT")) return false;
        // Verificar se após PT há apenas dígitos
        for (int i = 2; i < codigo.length(); i++) {
            if (!Character.isDigit(codigo.charAt(i))) return false;
        }
        return true;
    }

    public boolean isValid() {
        return valid;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Iban outro = (Iban) obj;
        return Objects.equals(codigo, outro.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        if (!valid) return "[IBAN inválido]";
        return codigo;
    }
}
