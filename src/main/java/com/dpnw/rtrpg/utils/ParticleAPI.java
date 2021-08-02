package com.dpnw.rtrpg.utils;

import com.dpnw.rtrpg.RTRPG;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Marker;
import org.bukkit.entity.Monster;
import org.bukkit.util.Vector;

public class ParticleAPI {

    public static void lineParticleDamage(Location l1, Location l2, double space, Particle p, int count, double extra, double range, double damage) {
        double distance = l1.distance(l2);
        Vector p1 = l1.toVector();
        Vector p2 = l2.toVector();
        Vector vector = p2.clone().subtract(p1).normalize().multiply(space);
        double covered = 0;
        for (; covered < distance; p1.add(vector)) {
            for(Entity e : p1.toLocation(l1.getWorld()).getNearbyEntities(range, range, range)) {
                if(!(e instanceof Monster)) continue;
                ((Monster) e).damage(damage);
            }
            l1.getWorld().spawnParticle(p, p1.getX(), p1.getY(), p1.getZ(), count, 0, 0, 0, extra);
            covered += space;
        }
    }

    public static void spawnMarker(Location l1, double distance) {
        Marker m = (Marker) l1.getWorld().spawnEntity(l1.getDirection().multiply(distance).toLocation(l1.getWorld()), EntityType.MARKER);
        m.setGravity(false);
        m.setCustomNameVisible(false);
        Bukkit.getScheduler().runTaskLater(RTRPG.getInstance(), m::remove, 5L);
    }

    public static void lineParticleDamage(Location l1, double distance, double space, Particle p, int count, double extra, double range, double damage) {
        Vector p1 = l1.getDirection();
        Vector vector = p1.clone().normalize().multiply(distance);
        double covered = 0;
        for (; covered < distance; p1.add(vector)) {
            for(Entity e : p1.toLocation(l1.getWorld()).getNearbyEntities(range, range, range)) {
                if(!(e instanceof Monster)) continue;
                ((Monster) e).damage(damage);
            }
            l1.getWorld().spawnParticle(p, p1.getX(), p1.getY(), p1.getZ(), count, 0, 0, 0, extra);
            covered += space;
        }
    }

    public static void line(Location point1, Location point2, double space, Particle pp, double ox, double oy, double oz, int count, double extra) {
        double distance = point1.distance(point2);
        Vector p1 = point1.toVector();
        Vector p2 = point2.toVector();
        Vector vector = p2.clone().subtract(p1).normalize().multiply(space);
        double covered = 0;
        for (; covered < distance; p1.add(vector)) {
            point1.getWorld().spawnParticle(pp, p1.getX(), p1.getY(), p1.getZ(), count, ox, oy, oz, extra);
            covered += space;
        }
    }
}
