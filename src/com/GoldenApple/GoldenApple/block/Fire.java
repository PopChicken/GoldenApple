
use pocketmine\item\Item;
use pocketmine\entity\Entity;
use pocketmine\level\Level;
use pocketmine\event\entity\EntityDamageEvent;
use pocketmine\Server;

class Fire extends Flowable{
	public function __construct($meta = 0){
		parent::__construct(self::FIRE, $meta, "Fire");
		$this->isReplaceable = true;
		$this->breakable = false;
		$this->isFullBlock = true;
		$this->hardness = 0;
	}

	public function getBoundingBox(){
		return null;
	}

	public function onEntityCollide(Entity $entity){
		$entity->setOnFire(8);
		$ev = new EntityDamageEvent($entity, EntityDamageEvent::CAUSE_FIRE, 1);
		Server::getInstance()->getPluginManager()->callEvent($ev);
		if(!$ev->isCancelled()){
			$entity->attack($ev->getFinalDamage(), $ev);
		}
	}

	public function getDrops(Item $item){
		return [];
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			for($s = 0; $s <= 5; ++$s){
				$side = $this->getSide($s);
				if($side->getID() !== self::AIR and !($side instanceof Liquid)){
					return false;
				}
			}
			$this->getLevel()->setBlock($this, new Air(), true);

			return Level::BLOCK_UPDATE_NORMAL;
		}elseif($type === Level::BLOCK_UPDATE_RANDOM){
			if($this->getSide(0)->getID() !== self::NETHERRACK){
				$this->getLevel()->setBlock($this, new Air(), true);

				return Level::BLOCK_UPDATE_NORMAL;
			}
		}

		return false;
	}

}