
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\Player;

class Torch extends Flowable{
	public function __construct($meta = 0){
		parent::__construct(self::TORCH, $meta, "Torch");
		$this->hardness = 0;
	}

	public function getBoundingBox(){
		return null;
	}


	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			$side = $this->getDamage();
			$faces = [
				1 => 4,
				2 => 5,
				3 => 2,
				4 => 3,
				5 => 0,
				6 => 0,
				0 => 0,
			];

			if($this->getSide($faces[$side])->isTransparent === true and !($side === 0 and $this->getSide(0)->getID() === self::FENCE)){ //Replace with common break method
				$this->getLevel()->setBlock($this, new Air(), true);
				$this->getLevel()->dropItem($this->add(0.5, 0.5, 0.5), Item::get(Item::TORCH));

				return Level::BLOCK_UPDATE_NORMAL;
			}
		}

		return false;
	}

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		if($target->isTransparent === false and $face !== 0){
			$faces = [
				1 => 5,
				2 => 4,
				3 => 3,
				4 => 2,
				5 => 1,
			];
			$this->meta = $faces[$face];
			$this->getLevel()->setBlock($block, $this, true, true);

			return true;
		}elseif($this->getSide(0)->isTransparent === false or $this->getSide(0)->getID() === self::FENCE){
			$this->meta = 0;
			$this->getLevel()->setBlock($block, $this, true, true);

			return true;
		}

		return false;
	}

	public function getDrops(Item $item){
		return [
			[$this->id, 0, 1],
		];
	}
}