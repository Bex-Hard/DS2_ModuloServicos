package org.jala.moduloservico.util;

/**
 * Interface para um Listener de Verificação de Senha.
 */
public interface SenhaVerificacaoListener {
    /**
     * Método chamado quando a senha é verificada.
     * @param senhaCorreta Indica se a senha está correta.
     */
    void onSenhaVerificada(boolean senhaCorreta);

}