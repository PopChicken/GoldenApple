
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\math\AxisAlignedBB;
use pocketmine\Player;
use pocketmine\entity\Entity;

class Ladder extends Transparent{
	public function __construct($meta = 0){
		parent::__construct(self::LADDER, $meta, "Ladder");
		$this->isSolid = false;
		$this->isFullBlock = false;
		$this->hardness = 2;
	}

	public function onEntityCollide(Entity $entity){
		$entity->fallDistance = 0;
	}

	public function getBoundingBox(){
		$f = 0.125;

		if($this->meta === 2){
			return new AxisAlignedBB(
				$this->x,
				$this->y,
				$this->z + 1 - $f,
				$this->x + 1,
				$this->y + 1,
				$this->z + 1
			);
		}elseif($this->meta === 3){
			return new AxisAlignedBB(
				$this->x,
				$this->y,
				$this->z,
				$this->x + 1,
				$this->y + 1,
				$this->z + $f
			);
		}elseif($this->meta === 4){
			return new AxisAlignedBB(
				$this->x + 1 - $f,
				$this->y,
				$this->z,
				$this->x + 1,
				$this->y + 1,
				$this->z + 1
			);
		}elseif($this->meta === 5){
			return new AxisAlignedBB(
				$this->x,
				$this->y,
				$this->z,
				$this->x + $f,
				$this->y + 1,
				$this->z + 1
			);
		}

		return null;
	}


	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		if($target->isTransparent === false){
			$faces = [
				2 => 2,
				3 => 3,
				4 => 4,
				5 => 5,
			];
			if(isset($faces[$face])){
				$this->meta = $faces[$face];
				$this->getLevel()->setBlock($block, $this, true, true);

				return true;
			}
		}

		return false;
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			/*if($this->getSide(0)->getID() === self::AIR){ //Replace with common break method
				Server::getInstance()->api->entity->drop($this, Item::get(LADDER, 0, 1));
				$this->getLevel()->setBlock($this, new Air(), true, true, true);
				return Level::BLOCK_UPDATE_NORMAL;
			}*/
		}

		return false;
	}

	public function getDrops(Item $item){
		return [
			[$this->id, 0, 1],
		];
	}
}