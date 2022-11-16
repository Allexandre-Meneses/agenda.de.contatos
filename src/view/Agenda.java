package view;

import java.util.List;

import model.Pessoa;

public abstract class Agenda {
    public abstract void adicionar(Pessoa p);

    public abstract List<Pessoa> buscar(Character inicial);
}
