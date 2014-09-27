
class Bed extends Transparent{
	public function __construct($type = 0){
		parent::__construct(self::BED_BLOCK, $type, "Bed Block");
		$this->isActivable = true;
		$this->isFullBlock = false;
		$this->hardness = 1;
	}

	public function getBoundingBox(){
		return new AxisAlignedBB(
			$this->x,
			$this->y,
			$this->z,
			$this->x + 1,
			$this->y + 0.5625,
			$this->z + 1
		);
	}

	public function onActivate(Item $item, Player $player = null){

		$time = $this->getLevel()->getTime() % Level::TIME_FULL;

		$isNight = ($time >= Level::TIME_NIGHT and $time < Level::TIME_SUNRISE);

		if($player instanceof Player and !$isNight){
			$pk = new ChatPacket;
			$pk->message = "You can only sleep at night";
			$player->dataPacket($pk);

			return true;
		}

		$blockNorth = $this->getSide(2); //Gets the blocks around them
		$blockSouth = $this->getSide(3);
		$blockEast = $this->getSide(5);
		$blockWest = $this->getSide(4);
		if(($this->meta & 0x08) === 0x08){ //This is the Top part of bed
			$b = $this;
		}else{ //Bottom Part of Bed
			if($blockNorth->getID() === $this->id and ($blockNorth->meta & 0x08) === 0x08){
				$b = $blockNorth;
			}elseif($blockSouth->getID() === $this->id and ($blockSouth->meta & 0x08) === 0x08){
				$b = $blockSouth;
			}elseif($blockEast->getID() === $this->id and ($blockEast->meta & 0x08) === 0x08){
				$b = $blockEast;
			}elseif($blockWest->getID() === $this->id and ($blockWest->meta & 0x08) === 0x08){
				$b = $blockWest;
			}else{
				if($player instanceof Player){
					$pk = new ChatPacket;
					$pk->message = "This bed is incomplete";
					$player->dataPacket($pk);
				}

				return true;
			}
		}

		if($player instanceof Player and $player->sleepOn($b) === false){
			$pk = new ChatPacket;
			$pk->message = "This bed is occupied";
			$player->dataPacket($pk);
		}

		return true;
	}

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$down = $this->getSide(0);
		if($down->isTransparent === false){
			$faces = [
				0 => 3,
				1 => 4,
				2 => 2,
				3 => 5,
			];
			$d = $player instanceof Player ? $player->getDirection() : 0;
			$next = $this->getSide($faces[(($d + 3) % 4)]);
			$downNext = $this->getSide(0);
			if($next->isReplaceable === true and $downNext->isTransparent === false){
				$meta = (($d + 3) % 4) & 0x03;
				$this->getLevel()->setBlock($block, Block::get($this->id, $meta), true, true);
				$this->getLevel()->setBlock($next, Block::get($this->id, $meta | 0x08), true, true);

				return true;
			}
		}

		return false;
	}

	public function onBreak(Item $item){
		$blockNorth = $this->getSide(2); //Gets the blocks around them
		$blockSouth = $this->getSide(3);
		$blockEast = $this->getSide(5);
		$blockWest = $this->getSide(4);

		if(($this->meta & 0x08) === 0x08){ //This is the Top part of bed
			if($blockNorth->getID() === $this->id and $blockNorth->meta !== 0x08){ //Checks if the block ID and meta are right
				$this->getLevel()->setBlock($blockNorth, new Air(), true, true);
			}elseif($blockSouth->getID() === $this->id and $blockSouth->meta !== 0x08){
				$this->getLevel()->setBlock($blockSouth, new Air(), true, true);
			}elseif($blockEast->getID() === $this->id and $blockEast->meta !== 0x08){
				$this->getLevel()->setBlock($blockEast, new Air(), true, true);
			}elseif($blockWest->getID() === $this->id and $blockWest->meta !== 0x08){
				$this->getLevel()->setBlock($blockWest, new Air(), true, true);
			}
		}else{ //Bottom Part of Bed
			if($blockNorth->getID() === $this->id and ($blockNorth->meta & 0x08) === 0x08){
				$this->getLevel()->setBlock($blockNorth, new Air(), true, true);
			}elseif($blockSouth->getID() === $this->id and ($blockSouth->meta & 0x08) === 0x08){
				$this->getLevel()->setBlock($blockSouth, new Air(), true, true);
			}elseif($blockEast->getID() === $this->id and ($blockEast->meta & 0x08) === 0x08){
				$this->getLevel()->setBlock($blockEast, new Air(), true, true);
			}elseif($blockWest->getID() === $this->id and ($blockWest->meta & 0x08) === 0x08){
				$this->getLevel()->setBlock($blockWest, new Air(), true, true);
			}
		}
		$this->getLevel()->setBlock($this, new Air(), true, true);

		return true;
	}

	public function getDrops(Item $item){
		return [
			[Item::BED, 0, 1],
		];
	}

}