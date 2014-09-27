
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\Player;

class Dandelion extends Flowable{
	public function __construct(){
		parent::__construct(self::DANDELION, 0, "Dandelion");
		$this->hardness = 0;
	}

	public function getBoundingBox(){
		return null;
	}


	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$down = $this->getSide(0);
		if($down->getID() === 2 or $down->getID() === 3 or $down->getID() === 60){
			$this->getLevel()->setBlock($block, $this, true, true);

			return true;
		}

		return false;
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			if($this->getSide(0)->isTransparent === true){ //Replace with common break method
				//TODO
				//Server::getInstance()->api->entity->drop($this, Item::get($this->id));
				$this->getLevel()->setBlock($this, new Air(), false, false, true);

				return Level::BLOCK_UPDATE_NORMAL;
			}
		}

		return false;
	}
}