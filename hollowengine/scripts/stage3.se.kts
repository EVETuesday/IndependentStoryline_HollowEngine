import ru.hollowhorizon.hollowengine.common.scripting.StoryLogger
import net.minecraft.core.particles.DustParticleOptions
import net.minecraft.world.phys.*
import com.mojang.math.Vector3f
import net.minecraft.server.level.ServerLevel


fun IContextBuilder.sayWithDelay(npc: Safe<NPCEntity>, msg: () -> String) {
	val realMsg = msg()
	npc say {realMsg}
	wait {20 + realMsg.split(" ").size * 5}
}

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

val startPos = Vec3(-1531.5, 220.0, 65.5)
val endPos = Vec3(-1531.5, 220.0, -180.5)
var stepN = 0
var steps = 300

val pathAsync = async {
	While ({true}) {
		next {
			while (stepN < steps) {
				stepN++
				var pos = startPos.add(endPos.subtract(startPos).scale((stepN.toDouble()) / steps))
				(player.level as ServerLevel).sendParticles(player, DustParticleOptions(Vector3f(0.13f, 0.58f, 0.71f), 2.0f), true, pos.x, pos.y, pos.z, 2, 0.0, 0.0, 0.0, 0.1);
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
	pos = pos(-1532, 200, 45)
	radius = 7.0
	createIcon = false
}

sayWithDelay(gerdec, {"Это был отличный город, люди были в достатке и ничего не боялись."})
wait {defaultSayDelay}
sayWithDelay(gerdec, {"Но потом пришёл он..."})
wait {defaultSayDelay}
players say {"Почему Модиум решился на такое?"}
wait {defaultSayDelay}
sayWithDelay(gerdec, {"А кто его знает, возьмём этого засранца и выясним всё."})
players say {"Гердес, а где все люди?"}
wait {defaultSayDelay}
players say {"Почему в городе пусто?"}
wait {defaultSayDelay}
sayWithDelay(gerdec, {"Они боятся, Модиум внушил народу страх и боязнь, никто не хочет выходить из дома, так как боится быть пойманным и убитым."})

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
sayWithDelay(modium, {"Повстанец. Какими судьбами?"})
players say {"Я о тебе наслышан. Многие говорят не лестное."}
wait {defaultSayDelay}
modium lookAlwaysAt {player}
sayWithDelay(modium, {"И что говорят?"})
wait {defaultSayDelay}
players say {"Что ты испортил всем жизнь."}
wait {defaultSayDelay}
sayWithDelay(modium, {"Смешно. Жизнь испортили люди себе сами."})
sayWithDelay(modium, {"Могли же понять, что я для них стараюсь и не нужно сопротивляться."})
sayWithDelay(modium, {"Но кто-то поиграть в героев решил и создал повстанческие группы."})
players say {"Ты захватил власть черным путем и за это ты должен ответить перед народом."}
wait {defaultSayDelay}
sayWithDelay(modium, {"Я тебя раньше не видел. Кто ты?"})
players say {"Это не важно."}
wait {defaultSayDelay}
players say {"Сдайся пока не поздно, пока все не отвернулись от тебя окончательно."}
wait {defaultSayDelay}
sayWithDelay(modium, {"Ты не знаешь всей картины."})
sayWithDelay(modium, {"И что сверг я власть по весомым причинам."})
sayWithDelay(modium, {"Если ты сейчас всё свои оружие сложишь на пол и примкнешь ко мне, я пощажу тебя."})
sayWithDelay(modium, {"Ты сможешь узнать, как оказался тут, кто ты и зачем ты здесь."})
sayWithDelay(modium, {"Я помогу достичь тебе всех амбиций, что у тебя есть."})
sayWithDelay(modium, {"Мне нужна помощь."})
sayWithDelay(modium, {"Я расскажу тебе, почему я пошел на такой проступок."})
players say {"Думаю, я сам всего добьюсь. Мне не нужна помощь."}
