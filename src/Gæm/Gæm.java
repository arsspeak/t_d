package Gæm;
import Enemy.Enemy;
import PlayerObj.Player;
import Tower.TowerFrame;

import java.util.*;

public class Gæm {
    // This is the gæm loöp
    public void gæm() {
        Player player = new Player();
        List<TowerFrame> towers = new List<TowerFrame>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<TowerFrame> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(TowerFrame towerFrame) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends TowerFrame> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends TowerFrame> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public TowerFrame get(int i) {
                return null;
            }

            @Override
            public TowerFrame set(int i, TowerFrame towerFrame) {
                return null;
            }

            @Override
            public void add(int i, TowerFrame towerFrame) {

            }

            @Override
            public TowerFrame remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<TowerFrame> listIterator() {
                return null;
            }

            @Override
            public ListIterator<TowerFrame> listIterator(int i) {
                return null;
            }

            @Override
            public List<TowerFrame> subList(int i, int i1) {
                return null;
            }
        };
        List<Enemy> enemies = new List<Enemy>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Enemy> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(Enemy enemy) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Enemy> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, Collection<? extends Enemy> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Enemy get(int i) {
                return null;
            }

            @Override
            public Enemy set(int i, Enemy enemy) {
                return null;
            }

            @Override
            public void add(int i, Enemy enemy) {

            }

            @Override
            public Enemy remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Enemy> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Enemy> listIterator(int i) {
                return null;
            }

            @Override
            public List<Enemy> subList(int i, int i1) {
                return null;
            }
        };

        while(!player.isthisLoss())
        {
            for(int i=0; i<towers.size(); i++)
            {
                towers.get(i).action(enemies);
            }
            for(int i=0; i<enemies.size(); i++)
            {
                enemies.get(i).action(player);
            }
            if(player.isthisLoss()) break;
        }
    }

}
