import ru.hollowhorizon.hollowengine.common.scripting.StoryLogger
import net.minecraft.core.particles.DustParticleOptions
import net.minecraft.world.phys.*
import com.mojang.math.Vector3f
import net.minecraft.server.level.ServerLevel


val players by server.players
val player = players().first()
val defaultSayDelay = 50

// remove this after tests
// --------
fadeIn {
	color = 0x000000
	time = 2.sec
}

//var walkToPlayerTask = async {
//	While({true}) {
//		var moveToPos = pos(-1530, 204, 112)
//		next {
//			StoryLogger.LOGGER.info("{} {}", pos(player.xOld, player.yOld, player.zOld), player.position())
//			moveToPos = player.position().add(1.5, 0.0, -3.5)
//		}
//		gerdec.moveAlwaysTo{moveToPos}
//	}
//}
// --------

players tpTo {
	pos = pos(-1527.5, 204, 114.5)
	vec = vec(-90, 10)
}

val gerdec by NPCEntity.creating {
	name = "Гердес"
	pos = pos(-1531, 204, 109)
	attributes = Attributes("generic.movement_speed" to 0.36f)
	model = "is:models/npc/gerdec.gltf"
	textures["classic"] = ""
}

val fancia by NPCEntity.creating {
	name = "Фанзия"
	pos = pos(-1530, 204, 115)
	model = "is:models/npc/fanzia.gltf"
	textures["classic"] = ""
}

gerdec lookAlwaysAt {player}
fancia lookAlwaysAt {player}

fadeOut {
	color = 0x000000
	time = 2.sec
}

val startPos = Vec3(-1530.5, 220.0, 65.5)
val endPos = Vec3(-1530.5, 220.0, -180.5)
var stepN = 0
var steps = 300

val pathAsync = async {
	While ({true}) {
		next {
			while (stepN < steps) {
				stepN++
				var pos = startPos.add(endPos.subtract(startPos).scale((stepN.toDouble()) / steps))
				(player.level as ServerLevel).sendParticles(player, DustParticleOptions(Vector3f(0.7f, 0.7f, 1.0f), 1.0f), true, pos.x, pos.y, pos.z, 2, 0.0, 0.0, 0.0, 0.1);
			}
			stepN = 0
		}
		wait {5}
	}
}

wait {25}
fancia say {"Гердес и Гельмо, удачи! Мы с Альфией и Миндосом летим помогать сверху."}

players waitPos {
	pos = pos(-1530, 204, 108)
	radius = 2.0
	createIcon = false
}

gerdec.stopLookAlways()
gerdec moveAlwaysTo {player}

players waitPos {
	pos = pos(-1532, 200, -22)
	radius = 7.0
	createIcon = false
}

gerdec say {"Это был отличный город, люди были в достатке и ничего не боялись. Но потом пришёл он..."}
wait {defaultSayDelay * 2}
players say {"Почему Модиум решился на такое?"}
wait {defaultSayDelay}
gerdec say {"А кто его знает, возьмём этого засранца и выясним всё."}
wait {defaultSayDelay * 4}
players say {"Гердес, а где все люди? Почему в городе пусто?"}
wait {defaultSayDelay * 2}
gerdec say {"Они боятся, Модиум внушил народу страх и боязнь, никто не хочет выходить из дома, так как боится быть пойманным и убитым."}

players waitPos {
	pos = pos(-1531, 203, -179)
	radius = 2.0
	createIcon = false
}

gerdec moveAlwaysTo {pos(-1530, 203, -180)}
gerdec lookAlwaysAt {player}
gerdec say {"Удачи!"}

val modium by NPCEntity.creating {
	name = "Модиум"
	pos = pos(-1537, 291, -184)
	model = "is:models/npc/modium.gltf"
	textures["classic"] = ""
}

pathAsync.stop()

players waitPos {
	pos = pos(-1531, 291, -227)
	radius = 6.0
	createIcon = false
	ignoreY = false
}

wait {50}
modium say {"Повстанец. Какими судьбами?"}
wait {defaultSayDelay}
players say {"Я о тебе наслышан. Многие говорят не лестное."}
wait {defaultSayDelay}
modium lookAlwaysAt {player}
modium say {"И что говорят?"}
wait {defaultSayDelay}
players say {"Что ты испортил всем жизнь."}
wait {defaultSayDelay}
modium say {"Смешно. Жизнь испортили люди себе сами. Могли же понять, что я для них стараюсь и не нужно сопротивляться. Но кто-то поиграть в героев решил и создал  повстанческие группы."}
wait {defaultSayDelay * 3}
players say {"Ты захватил власть черным путем и за это ты должен ответить перед народом."}
wait {defaultSayDelay}
modium say {"Я тебя раньше не видел. Кто ты?"}
wait {defaultSayDelay}
players say {"Это не важно. Сдайся пока не поздно, пока все не отвернулись от тебя окончательно. "}
wait {defaultSayDelay * 2}
modium say {"Ты не знаешь всей картины. И что сверг я власть по весомым причинам."}
wait {defaultSayDelay * 2}
modium say {"Если ты сейчас всё свои оружие сложишь на пол и примкнешь ко мне, я пощажу тебя."}
wait {defaultSayDelay * 2}
modium say {"Ты сможешь узнать, как оказался тут, кто ты и зачем ты здесь."}
wait {defaultSayDelay * 2}
modium say {"Я помогу достичь тебе всех амбиций, что у тебя есть. Мне нужна помощь. Я расскажу тебе, почему я пошел на такой проступок. "}
wait {defaultSayDelay * 2}
players say {"Думаю, я сам всего добьюсь. Мне не нужна помощь."}
