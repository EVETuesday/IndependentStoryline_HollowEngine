val team by server.players
val modium by NPCEntity.creating {
    name = "Модиум" //Имя персонажа
    model = "is:models/npc/modium.gltf" //Путь к модели персонажа
    attributes = Attributes( //список атрибутов персонажа (здоровье, скорость и т.п.) - всё как в команде /attribute
        "minecraft:generic.max_health" to 10000f,
        "minecraft:generic.movement_speed" to 0.2f, //к примеру здоровье
    )
    animations[AnimationType.IDLE] = "modium"
    animations[AnimationType.WALK] = "walk"
    showName = true //показывать ли ник с именем над нпс
    pos = pos(-1531.54, 291.06, -206.78) //координаты где спавнить нпс
}

modium moveTo {pos(-1531.54, 291.06, -226.78)}

