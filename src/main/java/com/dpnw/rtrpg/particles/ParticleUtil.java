package com.dpnw.rtrpg.particles;

import com.dpnw.rtrpg.RTRPG;
import org.bukkit.*;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.util.Vector;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

@SuppressWarnings("all")
public class ParticleUtil {
    public static void createParticle(Entity p, Particle pp, Location loc, double ox, double oy, double oz, int count,
                                      double extra) {
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> p.getWorld().spawnParticle(pp, loc.getX(), loc.getY(), loc.getZ(), count, ox,
                oy, oz, extra));
    }

    public static void createParticle(Particle pp, Location loc, double ox, double oy, double oz, int count,
                                      double extra) {
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> loc.getWorld().spawnParticle(pp, loc.getX(), loc.getY(), loc.getZ(), count, ox,
                oy, oz, extra));
    }

    public static void createParticle(Player p, Particle pp, Location loc, double ox, double oy, double oz, int count, double extra, Color color) {
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> p.getWorld().spawnParticle(pp, loc.getX(), loc.getY(), loc.getZ(), count, ox,
                oy, oz, extra, new Particle.DustOptions(color, 1)));
    }

    public static void firework(Location loc, Color color) {
        Firework fw = loc.getWorld().spawn(loc, Firework.class);
        FireworkMeta fm = fw.getFireworkMeta();
        fm.setPower(0);
        fm.addEffect(FireworkEffect.builder().withColor(color).with(Type.BALL_LARGE).build());
        fw.setFireworkMeta(fm);
    }

    public static void dot(Player p, int count, double size, Color color) {
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> p.getWorld().spawnParticle(Particle.REDSTONE, p.getLocation(), count,
                new Particle.DustOptions(color, (float) size)));
    }

    public static void around(Entity p, double size, Color color) {
        Location location = p.getLocation();
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            for (int degree = 0; degree < 360; degree += 5) {
                double radians = Math.toRadians(degree);
                double x = cos(radians) * size;
                double z = sin(radians) * size;
                location.add(x, 0, z);
                p.getWorld().spawnParticle(Particle.REDSTONE, location, 1, new Particle.DustOptions(color, 1));
                location.subtract(x, 0, z);
            }
        });
    }

    public static void fullCircle(Location loc, double size, Color color) {
        Location loc1 = loc.clone();
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            for (int degree = 0; degree < 360; degree += 5) {
                double radians = Math.toRadians(degree);
                double x = cos(radians) * size;
                double z = sin(radians) * size;
                loc.add(x, 0, z);
                line(loc1, loc, 0.3, color);
                loc.subtract(x, 0, z);
            }
        });
    }

    public static void column(Location loc, double size, double height, Color color) { //기둥?
        Location loc1 = loc.clone();
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            for (int degree = 0; degree < 360; degree += 10) {
                double radians = Math.toRadians(degree);
                double x = cos(radians) * size;
                double z = sin(radians) * size;
                loc.add(x, 0, z);
                line(loc1, loc, 0.5, color);
                line(loc, loc.clone().add(0, height, 0), 0.4, color);
                loc.subtract(x, 0, z);

            }
        });
    }

    public static void line(Location point1, Location point2, double space, Color color) {
        double distance = point1.distance(point2);
        Vector p1 = point1.toVector();
        Vector p2 = point2.toVector();
        Vector vector = p2.clone().subtract(p1).normalize().multiply(space);
        double covered = 0;
        for (; covered < distance; p1.add(vector)) {
            point1.getWorld().spawnParticle(Particle.REDSTONE, p1.getX(), p1.getY(), p1.getZ(), 1,
                    new Particle.DustOptions(color, 1));
            covered += space;
        }
    }

    public static void line(Location point1, Location point2, double space, Particle pp, double ox, double oy,
                            double oz, int count, double extra) {
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

    public static void around(Location location, double min, double max, Color color) {
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            for (double d = min; d < max; d++) {
                for (int degree = 0; degree < 360; degree += 5) {
                    double radians = Math.toRadians(degree);
                    double x = cos(radians) * d;
                    double z = sin(radians) * d;
                    location.add(x, 0, z);
                    location.getWorld().spawnParticle(Particle.REDSTONE, location, 1,
                            new Particle.DustOptions(color, 1));
                    location.subtract(x, 0, z);
                }
            }
        });
    }

    public static void around(Entity p, double min, double max, Color color) {
        Location location = p.getLocation();
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            for (double d = min; d < max; d++) {
                for (int degree = 0; degree < 360; degree += 5) {
                    double radians = Math.toRadians(degree);
                    double x = cos(radians) * d;
                    double z = sin(radians) * d;
                    location.add(x, 0, z);
                    p.getWorld().spawnParticle(Particle.REDSTONE, location, 1, new Particle.DustOptions(color, 1));
                    location.subtract(x, 0, z);
                }
            }
        });
    }

    public static void around(Entity p, double min, double max, Particle particle, int count, double extra) {
        Location location = p.getLocation();
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            for (double d = min; d < max; d++) {
                for (int degree = 0; degree < 360; degree += 5) {
                    double radians = Math.toRadians(degree);
                    double x = cos(radians) * d;
                    double z = sin(radians) * d;
                    location.add(x, 0, z);
                    p.getWorld().spawnParticle(particle, location, 1);
                    createParticle(p, particle, location, 0, 0, 0, count, extra);
                    location.subtract(x, 0, z);
                }
            }
        });
    }

    public static void around(Entity p, double min, double max, double distance, Particle particle, int count,
                              double extra) {
        Location location = p.getLocation();
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            for (double d = min; d < max; d += distance) {
                for (int degree = 0; degree < 360; degree += 5) {
                    double radians = Math.toRadians(degree);
                    double x = cos(radians) * d;
                    double z = sin(radians) * d;
                    location.add(x, 0, z);
                    p.getWorld().spawnParticle(particle, location, 1);
                    createParticle(p, particle, location, 0, 0, 0, count, extra);
                    location.subtract(x, 0, z);
                }
            }
        });
    }

    public static void around(Entity p, double min, double max, double height, Color color) {
        Location location = p.getLocation();
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            for (double h = 0; h < height; h++) {
                for (double d = min; d < max; d++) {
                    for (int degree = 0; degree < 360; degree += 5) {
                        double radians = Math.toRadians(degree);
                        double x = cos(radians) * d;
                        double z = sin(radians) * d;
                        location.add(x, 0, z);
                        p.getWorld().spawnParticle(Particle.REDSTONE, location, 1,
                                new Particle.DustOptions(color, 1));
                        location.subtract(x, 0, z);
                    }
                }
                location.add(0, 1, 0);
            }
        });
    }

    public static void sphere(Location middle, double radius, Color color) {
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            for (double polarAnge = 0.0; polarAnge < 360.0; polarAnge += 15) {
                for (double elevationAngle = 0.0; elevationAngle < 180.0; elevationAngle += 15) {
                    double dx = radius * sin(Math.toRadians(elevationAngle))
                            * cos(Math.toRadians(polarAnge));
                    double dy = radius * sin(Math.toRadians(elevationAngle))
                            * sin(Math.toRadians(polarAnge));
                    double dz = radius * cos(Math.toRadians(elevationAngle));
                    middle.getWorld().spawnParticle(Particle.REDSTONE, middle.clone().add(dx, dy, dz), 0, dx, dy, dz,
                            new Particle.DustOptions(color, 1));
                }
            }
        });
    }

    public static void sphere(Location middle, double radius, double distance, Color color) {
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            for (double polarAnge = 0.0; polarAnge < 360.0; polarAnge += distance) {
                for (double elevationAngle = 0.0; elevationAngle < 180.0; elevationAngle += distance) {
                    double dx = radius * sin(Math.toRadians(elevationAngle))
                            * cos(Math.toRadians(polarAnge));
                    double dy = radius * sin(Math.toRadians(elevationAngle))
                            * sin(Math.toRadians(polarAnge));
                    double dz = radius * cos(Math.toRadians(elevationAngle));
                    middle.getWorld().spawnParticle(Particle.REDSTONE, middle.clone().add(dx, dy, dz), 0, dx, dy, dz,
                            new Particle.DustOptions(color, 3));
                }
            }
        });
    }

    public static void sphere(Location middle, double radius, double distance, Particle particle) {
        Bukkit.getScheduler().runTask(RTRPG.getInstance(), () -> {
            for (double polarAnge = 0.0; polarAnge < 360.0; polarAnge += distance) {
                for (double elevationAngle = 0.0; elevationAngle < 180.0; elevationAngle += distance) {
                    double dx = radius * sin(Math.toRadians(elevationAngle))
                            * cos(Math.toRadians(polarAnge));
                    double dy = radius * sin(Math.toRadians(elevationAngle))
                            * sin(Math.toRadians(polarAnge));
                    double dz = radius * cos(Math.toRadians(elevationAngle));
                    middle.getWorld().spawnParticle(particle, middle.clone().add(dx, dy, dz), 0, dx, dy, dz);
                }
            }
        });
    }

    public static void helix(Location loc, double height, double distance, Color color) {
        double rad;
        for (double y = height; y >= 0; y -= distance) {
            rad = y / 3;
            double x = rad * cos(3 * y);
            double z = rad * sin(3 * y);
            double y2 = height - y;
            Location loc2 = new Location(loc.getWorld(), loc.getX() + x, loc.getY() + y2, loc.getZ() + z);
            loc.getWorld().spawnParticle(Particle.REDSTONE, loc2, 1, new Particle.DustOptions(color, 1));
        }
        for (double y = height; y >= 0; y -= distance) {
            rad = y / 3;
            double x = -(rad * cos(3 * y));
            double z = -(rad * sin(3 * y));
            double y2 = height - y;
            Location loc2 = new Location(loc.getWorld(), loc.getX() + x, loc.getY() + y2, loc.getZ() + z);
            loc.getWorld().spawnParticle(Particle.REDSTONE, loc2, 1, new Particle.DustOptions(color, 1));
        }
    }

    public static void tornado(Location loc, double radius, int height, int lines, double distance, Color color) {
        int angle = 50;
        double radius_increasement = radius / height;
        for (int l = 0; l < lines; ++l) {
            for (double y = 0.0; y < height; y += distance) {
                double rad = y * radius_increasement;
                double a = Math.toRadians(360 / lines * l + y * 25.0 - angle);
                double x = cos(a) * rad;
                double z = sin(a) * rad;
                loc.getWorld().spawnParticle(Particle.REDSTONE, loc.clone().add(x, y, z), 1,
                        new Particle.DustOptions(color, 1));
            }
        }
    }

    public static void tornado(Location loc, double radius, double height, int lines, double distance, int angle,
                               Color color) {
        double radius_increasement = radius / height;
        for (int l = 0; l < lines; ++l) {
            for (double y = 0.0; y < height; y += distance) {
                double rad = y * radius_increasement;
                double a = Math.toRadians(360 / lines * l + y * 25.0 - angle);
                double x = cos(a) * rad;
                double z = sin(a) * rad;
                loc.getWorld().spawnParticle(Particle.REDSTONE, loc.clone().add(x, y, z), 1,
                        new Particle.DustOptions(color, 1));
            }
        }
    }

    public static void tornado(Location loc, double radius, double height, int lines, double distance, int angle,
                               Particle particle, int count, double extra) {
        double radius_increasement = radius / height;
        for (int l = 0; l < lines; ++l) {
            for (double y = 0.0; y < height; y += distance) {
                double rad = y * radius_increasement;
                double a = Math.toRadians(360 / lines * l + y * 25.0 - angle);
                double x = cos(a) * rad;
                double z = sin(a) * rad;
                loc.getWorld().spawnParticle(particle, loc.clone().add(x, y, z), count, 0, 0, 0, extra);
            }
        }
    }

    public static void donut(Location loc, double height, double radius, Color color) {
        loc.add(0, 2, 0);
        for (double r = 0; r < Math.PI * 2; r += Math.PI / 15) {
            double x = cos(r);
            double z = sin(r);
            for (double i = 0; i < height; i += 0.3) {
                double h = i * (Math.PI / height);
                double y = cos(h);
                double radiusEdit = sin(h);
                double inwardsRadius = radius - radiusEdit;
                double outwardsRadius = radius + radiusEdit;

                loc.add(x * inwardsRadius, y, z * inwardsRadius);
                loc.getWorld().spawnParticle(Particle.REDSTONE, loc.clone().add(x, y, z), 1,
                        new Particle.DustOptions(color, 1));
                loc.subtract(x * inwardsRadius, y, z * inwardsRadius);

                loc.add(x * outwardsRadius, y, z * outwardsRadius);
                loc.getWorld().spawnParticle(Particle.REDSTONE, loc.clone().add(x, y, z), 1,
                        new Particle.DustOptions(color, 1));
                loc.subtract(x * outwardsRadius, y, z * outwardsRadius);
            }
        }
    }

    public static void wave(Location loc, double range, Color color) {
        double t = Math.PI / 4;

        for (; t < range; t = t + 0.2 * Math.PI) {

            for (double theta = 0; theta <= 2 * Math.PI; theta = theta + Math.PI / 16) {
                double x = t * cos(theta);
                double v = Math.exp(-0.01 * t) * sin(t) + 1;
                double y = v;
                double z = t * sin(theta);
                loc.add(x, y, z);
                loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, new Particle.DustOptions(color, 1));
                loc.subtract(x, y, z);

                theta = theta + Math.PI / 24;

                x = t * cos(theta);
                y = v;
                z = t * sin(theta);
                loc.add(x, y, z);
                loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, new Particle.DustOptions(color, 1));
                loc.subtract(x, y, z);
            }
        }
    }

}
