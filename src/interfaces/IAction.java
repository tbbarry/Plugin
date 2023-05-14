package interfaces;

import model.Animal;
/**
 * Interface qui sera implementée par tous les plugins
 */
public interface IAction {
  void doAction(Animal a);
}
