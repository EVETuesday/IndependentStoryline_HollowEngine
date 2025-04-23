import ru.hollowhorizon.hollowengine.common.scripting.story.nodes.IContextBuilder
import ru.hollowhorizon.hollowengine.common.scripting.story.nodes.base.next
import kotlin.math.cos
import kotlin.math.sin

var staticSmoke = false

fun IContextBuilder.startSmoke(posX: Double, posY: Double, posZ: Double, radius: Double = 1.0) {
    next { staticSmoke = true }
    // Создаём круг мгновенно
    val particleCount = 200 // Количество точек на окружности
    for (i in 0 until particleCount) {
        val angle = (2 * Math.PI * i / particleCount) // Угол в радианах
        val x = posX + radius * cos(angle)
        val z = posZ + radius * sin(angle)
        // Увеличиваем количество частиц в каждой точке для плотности
        execute { "particle minecraft:dragon_breath $x $posY $z 0.02 0.02 0.02 0.005 10 force" }
    }
    // Поддерживаем видимость круга
    async {
        while (staticSmoke) {
            for (i in 0 until particleCount) {
                val angle = (2 * Math.PI * i / particleCount)
                val x = posX + radius * cos(angle)
                val z = posZ + radius * sin(angle)
                execute { "particle minecraft:dragon_breath $x $posY $z 0.02 0.02 0.02 0.005 10 force" }
            }
        }
    }
}

fun IContextBuilder.stopSmoke() {
    next { staticSmoke = false }
}

// Вызов функции с радиусом 1.0
startSmoke(608.0, 101.0, -1909.0, 1.0)